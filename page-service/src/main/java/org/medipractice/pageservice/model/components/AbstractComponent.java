package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractComponent implements Serializable {

    protected String type;
    protected String key;
    protected String label;
    protected String placeholder;
    protected Boolean input;
    protected Boolean tableView;
    protected Boolean multiple;
    @JsonProperty("protected")
    protected Boolean protect;
    protected Boolean prefix;
    protected Boolean suffix;
    protected Boolean clearOnHide;
    protected Boolean unique;
    protected Boolean persistent;
    protected Boolean hidden;
    protected Validate validate;
    protected Conditional conditional;
    protected Errors errors;
    protected List<Object> logic;


    protected List<AbstractComponent> components = new ArrayList<>();

    public static AbstractComponent setComponent(JsonNode c) {

        Map<String, Class<?>> componentMap = new HashMap<>();
        componentMap.put("address", Address.class);
        componentMap.put("button", Button.class);
        componentMap.put("checkbox", Checkbox.class);
        componentMap.put("columns", Columns.class);
        componentMap.put("container", Container.class);
        componentMap.put("content", Content.class);
        componentMap.put("currency", Currency.class);
        componentMap.put("custom", Custom.class);
        componentMap.put("datagrid", DataGrid.class);
        componentMap.put("datetime", DateTime.class);
        componentMap.put("day", Day.class);
        componentMap.put("email", Email.class);
        componentMap.put("fieldset", FieldSet.class);
        componentMap.put("file", File.class);
        componentMap.put("form", Form.class);
        componentMap.put("hidden", Hidden.class);
        componentMap.put("HTML", HTML.class);
        componentMap.put("number", Number.class);
        componentMap.put("panel", Panel.class);
        componentMap.put("password", Password.class);
        componentMap.put("phoneNumber", PhoneNumber.class);
        componentMap.put("radio", Radio.class);
//        componentMap.put("resource", Resource.class);
        componentMap.put("select", Select.class);
        componentMap.put("selectboxes", SelectBox.class);
        componentMap.put("signature", Signature.class);
        componentMap.put("survey", Survey.class);
        componentMap.put("table", Table.class);
        componentMap.put("textarea", TextArea.class);
        componentMap.put("textfield", TextField.class);
        componentMap.put("time", Time.class);
        componentMap.put("well", Well.class);

        ObjectMapper jsonObjectMapper = new ObjectMapper();
        jsonObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Class<?> compo = Components.class;

        if (c.has("type") && componentMap.containsKey(c.get("type").asText())) {
            compo = componentMap.get(c.get("type").asText());
        }

        try {

            log.info("TYPE = " + (c.get("type").asText()));
            return (AbstractComponent) jsonObjectMapper.treeToValue(c, compo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void setComponents(List<JsonNode> jsonNodes) {
        jsonNodes.forEach(c -> components.add(AbstractComponent.setComponent(c)));
    }

    @Data
    static class Validate {
        private String required;
        private String minLength;
        private String maxLength;
        private String pattern;
        private String custom;
        private String customMessage;
        private String json;
        private Integer min;
        private Integer max;
        private Integer step;
        private Boolean integer;

    }

    @Data
    static class Conditional {
        private String show;
        private String when;
        private String eq;
        private String json;

    }

    @Data
    static class Errors {
        private String required;
        private String min;
        private String max;
        private String minLength;
        private String maxLength;
        private String invalid_email;
        private String invalid_date;
        private String pattern;
        private String custom;
    }



}
