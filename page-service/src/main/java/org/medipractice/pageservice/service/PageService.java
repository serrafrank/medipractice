package org.medipractice.pageservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.medipractice.pageservice.dao.DaoManager;
import org.medipractice.pageservice.exception.ResourceNotFoundException;
import org.medipractice.pageservice.model.Field;
import org.medipractice.pageservice.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service de gestion des pages
 */
@Service
@Slf4j
public class PageService {

    //Couche DAO
    private final DaoManager daoManager;

    //clefs json
    private final static String COMPO_KEY = "key";
    private final static String COMPO_TYPE = "type";
    private final static String COMPO_COMPONENTS = "components";
    private final static String COMPO_LABEL = "label";

    //list des components supportés
    private List<String> supportedComponents = Arrays.asList("address", "button", "checkbox", "content", "currency", "custom", "dateTime", "day", "email", "file", "hidden", "htmlelement", "number", "password", "phoneNumber", "radio", "resource", "select", "selectboxes", "signature", "survey", "textarea", "textfield", "time");

    //Injection des repository dans le constructeur
    @Autowired
    public PageService(DaoManager daoManager) {
        this.daoManager = daoManager;
    }


    /**
     * Retourne une Page a partir du module et du nom de la page
     *
     * @param module
     * @param name
     * @return
     */
    public Page findByName(String module, String name) {
        Page page = daoManager.getPageRepository().findByModule_NameAndName(module, name).orElseThrow(() -> new ResourceNotFoundException("Name not found : " + module + " / " + name));
        page.setSchema(buildForms(page.getSchema()));
        return page;
    }

    /**
     * Enregistre/Update une page
     *
     * @param page
     * @return
     */
    @Transactional
    public Page save(Page page) {
        UUID id = (page.getId() != null) ? page.getId() : UUID.randomUUID();
        Page pageToSave = daoManager.getPageRepository().findById(id).orElse(new Page());

        if (page.getName() != null) pageToSave.setName(page.getName());
        if (page.getTitle() != null) pageToSave.setTitle(page.getTitle());
        if (page.getIcon() != null) pageToSave.setIcon(page.getIcon());
        if (page.getSubTitle() != null) pageToSave.setSubTitle(page.getSubTitle());
        if (page.getSchema() != null) pageToSave.setSchema(extractFields(page.getSchema()));

        if (page.getModule() != null) pageToSave.setModule(page.getModule());

        //enregistrement en base de donnée
        return daoManager.getPageRepository().save(pageToSave);
    }


    /**
     * Creation de la page
     *
     * @param page
     * @return
     */
    private JsonNode buildForms(JsonNode page) {
        if (page.has(COMPO_COMPONENTS)) {
            for (int i = 0; i < page.get(COMPO_COMPONENTS).size(); i++) {
                JsonNode component = page.get(COMPO_COMPONENTS).get(i);

                try {
                    Field field = daoManager.getFieldRepository().findByKey(component.get(COMPO_KEY).asText()).orElse(new Field());
                    component = field.getParameters();
                } catch (Exception e) {
                    component = buildForms(component);
                }

                ((ArrayNode) page.get(COMPO_COMPONENTS)).set(i, component);
            }
        }

        return page;
    }

    /**
     * Extraction des champs
     *
     * @param page
     * @return
     */
    private JsonNode extractFields(JsonNode page) {
        if (page.has(COMPO_COMPONENTS)) {
            //Extraction de la liste des components
            for (int i = 0; i < page.get(COMPO_COMPONENTS).size(); i++) {
                JsonNode component = page.get(COMPO_COMPONENTS).get(i);
                String key;
                if (component.has(COMPO_KEY)) {
                    key = component.get(COMPO_KEY).asText();
                } else {
                    key = Normalizer
                            .normalize((component.get(COMPO_TYPE).asText() + "_" + component.get(COMPO_LABEL).asText()), Normalizer.Form.NFD)
                            .replaceAll("[^\\p{ASCII}]", "")
                            .replaceAll(" ", "_")
                            .toLowerCase();
                }

                log.info(key);

                //recuperation du field en base de donnée s'il existe
                Optional<Field> optField = daoManager.getFieldRepository().findByKey(key);

                //verification si le componement ne contient pas d'autres elements impbriqués
                if (component.has(COMPO_TYPE)) {

                    if (this.supportedComponents.contains(component.get(COMPO_TYPE).asText())) {
                        //mise a jour de la clef du componement

                        if (!optField.isPresent()) {
                            Field field = new Field();
                            field.setKey(key);
                            //mise a jour des données en base
                            field.setCategory(component.get(COMPO_TYPE).asText());
                            field.setParameters(component);

                            //enregistrement / mise a jour
                            daoManager.getFieldRepository().save(field);
                        }

                        try {
                            component = new ObjectMapper().readTree("{\"" + COMPO_KEY + "\":\"" + key + "\"}");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        //si le component comporte des elements imbriqués, recursion
                        switch (component.get(COMPO_TYPE).asText()) {
                            case "columns":
                                for (int col = 0; col < component.get("columns").size(); col++)
                                    ((ArrayNode) component.get("columns")).set(col, extractFields(component.get("columns").get(col)));

                                break;

                            case "table":
                                for (int row = 0; row < component.get("rows").size(); row++) {
                                    for (int line = 0; line < component.get("rows").get(row).size(); line++)
                                        ((ArrayNode) component.get("rows").get(row)).set(line, extractFields(component.get("rows").get(row).get(line)));
                                }
                                break;
                            default:
                                component = extractFields(component);
                        }
                    }

                    ((ArrayNode) page.get(COMPO_COMPONENTS)).set(i, component);
                }
            }
        }
        return page;
    }

}
