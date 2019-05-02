package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class SelectBox extends AbstractComponent {

    private List<Value> values = new ArrayList<>();
    private Boolean inline;

    public SelectBox() {
        this.type = "selectboxes";
    }

    @Data
    class Value {
        private String label;
        private String value;
    }
}
