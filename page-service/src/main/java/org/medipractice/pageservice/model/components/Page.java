package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {
    private String title;
    private String name;
    private String path;
    private String type;
    private List<AbstractComponent> components = new ArrayList<>();

    public void setComponents(List<JsonNode> jsonNodes) {
        jsonNodes.forEach(c -> components.add(AbstractComponent.setComponent(c)));
    }
}
