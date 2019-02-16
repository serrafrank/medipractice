package org.medipractice.pageservice.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.medipractice.pageservice.exception.ResourceNotFoundException;
import org.medipractice.pageservice.model.Field;
import org.medipractice.pageservice.model.Page;
import org.medipractice.pageservice.repository.FieldRepository;
import org.medipractice.pageservice.repository.PageRepository;
import org.medipractice.pageservice.utils.NormalizeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PageService {

    private final PageRepository pageRepository;

    private final FieldRepository fieldRepository;
    
    private final static String FIELD_KEY = "field_key";
    private final static String COMPO_KEY = "key";
    private final static String COMPO_TYPE = "type";
    private final static String COMPO_COMPONENTS = "components";
    private final static String COMPO_LABEL = "label";

    private List<String> supportedComponents = Arrays.asList("address", "button", "checkbox", "content", "currency", "custom", "dateTime", "day", "email", "file", "hidden", "htmlelement", "number", "password", "phoneNumber", "radio", "resource", "select", "selectboxes", "signature", "survey", "textarea", "textfield", "time");

    @Autowired
    public PageService(PageRepository pageRepository, FieldRepository fieldRepository) {
        this.pageRepository = pageRepository;
        this.fieldRepository = fieldRepository;
    }

    public Page findByName(String module, String name) {
        Page page = pageRepository.findByModule_NameAndName(module, name).orElseThrow(() -> new ResourceNotFoundException("Name not found : " + module + " / " + name));
        JSONObject json = new JSONObject(page.getSchema());
        page.setSchema( buildForms(json).toString() );
        return page;
    }

    public Page save(Page page) {
        JSONObject extractFields = extractFields(new JSONObject(page.getSchema()));
        page.setSchema(extractFields.toString());
        return pageRepository.save(page);
    }


    private JSONObject buildForms(JSONObject page){
        if (page.has(COMPO_COMPONENTS)) {
            JSONArray components = page.getJSONArray(COMPO_COMPONENTS);
            for (int i = 0; i < components.length(); i++) {
                JSONObject component = components.getJSONObject(i);
                if (component.has(FIELD_KEY) ) {
                    String fieldKey = component.getString(FIELD_KEY);
                    Field field = fieldRepository.findByFieldKey(fieldKey).orElseThrow(() -> new ResourceNotFoundException("Field key not found : " + fieldKey));
                    component = new JSONObject(field.getParameters());

                }else if (component.has(COMPO_COMPONENTS) ) {
                    component = buildForms(component);
                }
                components.put(i, component);
            }
        }

        return page;
    }

    private JSONObject extractFields(JSONObject page) {

        if (page.has(COMPO_COMPONENTS)) {
            JSONArray components = page.getJSONArray(COMPO_COMPONENTS);
            for (int i = 0; i < components.length(); i++) {
                JSONObject component = components.getJSONObject(i);

                Field field = new Field();

                if (component.has(FIELD_KEY)) {
                    field = fieldRepository.findByFieldKey(component.getString(FIELD_KEY)).orElse(new Field());
                }

                if (field.getId() == null) {
                    if (component.has(COMPO_TYPE) && this.supportedComponents.contains(component.getString(COMPO_TYPE))) {

                        String fieldKey = NormalizeName.of(component.getString(COMPO_TYPE) + "_" + component.getString(COMPO_LABEL)).toString();

                        component.put(COMPO_KEY, fieldKey);
                        
                        field.setFieldKey(fieldKey);
                        field.setCategory(component.getString(COMPO_TYPE));
                        field.setLabel(component.getString(COMPO_LABEL));
                        field.setParameters(component.toString());

                        fieldRepository.save(field);

                        component = new JSONObject().put(FIELD_KEY,  fieldKey);

                    } else {
                        component = extractFields(component) ;
                    }
                } else {
                    component = new JSONObject().put(FIELD_KEY, field.getFieldKey());
                }
                page.getJSONArray(COMPO_COMPONENTS).put(i, component);
            }
        }
        return page;
    }


}
