package org.medipractice.pageservice.service;

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
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
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
        JSONObject json = new JSONObject(page.getSchema());
        page.setSchema(buildForms(json).toString());
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
        if (page.getSchema() != null) {
            JSONObject extractFields = extractFields(new JSONObject(page.getSchema()));
            pageToSave.setSchema(extractFields.toString());
        }
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
    private JSONObject buildForms(JSONObject page) {
        if (page.has(COMPO_COMPONENTS)) {
            //Extraction de la liste des components
            JSONArray components = page.getJSONArray(COMPO_COMPONENTS);

            for (int i = 0; i < components.length(); i++) {
                //recuperation de l'objet
                JSONObject component = components.getJSONObject(i);
                UUID uuid;
                try {
                    Field field = daoManager.getFieldRepository().findByKey(component.getString(COMPO_KEY)).orElse(new Field());
                    component = new JSONObject(field.getParameters());
                } catch (Exception e) {
                    component = buildForms(component);
                }

                components.put(i, component);
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
    private JSONObject extractFields(JSONObject page) {

        if (page.has(COMPO_COMPONENTS)) {
            //Extraction de la liste des components
            JSONArray components = page.getJSONArray(COMPO_COMPONENTS);
            for (int i = 0; i < components.length(); i++) {
                //recuperation de l'objet
                JSONObject component = components.getJSONObject(i);

                String key = component.getString(COMPO_KEY);

                //recuperation du field en base de donnée s'il existe, sinon creation d'un nouveau field
                Field field = daoManager.getFieldRepository().findByKey(key).orElse(new Field());

                //verification si le componement ne contient pas d'autres elements impbriqués
                if (component.has(COMPO_TYPE) && this.supportedComponents.contains(component.getString(COMPO_TYPE))) {
                    //mise a jour de la clef du componement

                    if (field.getId() == null) {
                        key = Normalizer
                                .normalize(component.getString(COMPO_LABEL), Normalizer.Form.NFD)
                                .replaceAll("[^\\p{ASCII}]", "")
                                .replaceAll(" ", "_")
                                .toLowerCase();

                        field.setKey(key);

                    } else {
                        key = field.getKey();
                    }

                    component.put(COMPO_KEY, key);


                    //mise a jour des données en base
                    field.setCategory(component.getString(COMPO_TYPE));
                    field.setParameters(component.toString());

                    //enregistrement / mise a jour
                    daoManager.getFieldRepository().save(field);

                    component = new JSONObject().put(COMPO_KEY, key);

                } else {
                    //si le component comporte des elements imbriqués, recursion
                    component = extractFields(component);
                }

                //mise a jour de la page
                page.getJSONArray(COMPO_COMPONENTS).put(i, component);
            }
        }
        return page;
    }

}
