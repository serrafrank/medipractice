package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class Columns extends AbstractComponent {

    private List<ArrayColumns> columns = new ArrayList<>();

    public Columns() {
        this.type = "columns";
    }

    @Data
    class ArrayColumns {
        private Integer width;
        private Integer offset;
        private Integer push;
        private Integer pull;

        public void setComponents(List<JsonNode> jsonNode) {
            jsonNode.forEach(c -> components.add(AbstractComponent.setComponent(c)));
        }
    }


}
