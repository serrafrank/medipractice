package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class SelectComponent extends CommonProperties {

    private String type = "select";
    private String dataSrc;

    private Map<String, String> values = new HashMap<>();

    private String data_json;

    private String data_url;

    private String data_resource;

    private String data_custom;

    private String valueProperty;

    private String refreshOn;

    private String filter;

    private boolean authenticate;

    private String template;

    
}
