package org.medipractice.pageservice.service;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.pageservice.dao.DaoManager;
import org.medipractice.pageservice.exception.ResourceNotFoundException;
import org.medipractice.pageservice.model.Field;
import org.medipractice.pageservice.model.Page;
import org.medipractice.pageservice.model.components.Components;
import org.medipractice.pageservice.model.components.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        page.getSchema().setComponents(buildForms(page.getSchema().getComponents()));
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
            pageToSave.setSchema(new Schema());
            pageToSave.getSchema().setDisplay(page.getSchema().getDisplay());
            pageToSave.getSchema().setComponents(extractFields(page.getSchema().getComponents()));
        }
        if (page.getModule() != null) pageToSave.setModule(page.getModule());

        //enregistrement en base de donnée
        return daoManager.getPageRepository().save(pageToSave);
    }


    /**
     * Creation de la page
     *
     * @param components
     * @return
     */

    private List<Components> buildForms(List<Components> components) {

        for (int i = 0; i < components.size(); i++) {
            Components build = buildForms(components.get(i));
            components.set(i, build);
        }
        return components;

    }

    private Components buildForms(Components component) {
        String key = component.getInternalKey();


        if (component.getInternalKey() != null) {
            Field field = daoManager.getFieldRepository().findByKey(component.getInternalKey()).orElseThrow(() -> new ResourceNotFoundException("Field not found with internalKey = "));
            component = field.getParameters();
        } else if (component.getComponents().size() > 0) {
            component.setComponents(buildForms(component.getComponents()));
        }

        return component;
    }


    /**
     * Extraction des champs
     *
     * @param components
     * @return
     */


    private List<Components> extractFields(List<Components> components) {

        for (int i = 0; i < components.size(); i++) {
            Components extracted = extractFields(components.get(i));
            components.set(i, extracted);
        }
        return components;

    }


    private Components extractFields(Components component) {


        if (supportedComponents.contains(component.getType())) {

            String key;


            key = Normalizer
                    .normalize((component.getType() + "_" + component.getLabel()), Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "")
                    .replaceAll(" ", "_")
                    .toLowerCase();


            //recuperation du field en base de donnée s'il existe
            Optional<Field> optField = daoManager.getFieldRepository().findByKey(key);

            if (!optField.isPresent()) {
                Field field = new Field();
                field.setKey(key);
                //mise a jour des données en base
                field.setCategory(component.getType());
                field.setParameters(component);

                //enregistrement / mise a jour
                daoManager.getFieldRepository().save(field);

            }
            component = new Components();
            component.setInternalKey(key);


        } else if (component.getComponents().size() > 0) {

            component.setComponents(extractFields(component.getComponents()));

        }

        log.info(">>>> component extracted = " + component);

        return component;
    }

}
