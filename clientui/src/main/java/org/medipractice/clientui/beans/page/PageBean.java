package org.medipractice.clientui.beans.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
public class PageBean implements Serializable {

    private UUID id;

    private String name;

    private String title;

    private String icon;

    private String subTitle;

    private Set<String> fields;

    private JsonNode schema;

    private UUID module;

}
