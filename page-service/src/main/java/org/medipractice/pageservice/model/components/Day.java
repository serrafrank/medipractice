package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class Day extends AbstractComponent {

    private Fields fields;
    private Boolean dayFirst;


    public Day() {
        this.type = "day";
    }

    @Data
    class Fields {
        private FieldsProperties day;
        private FieldsProperties month;
        private FieldsProperties year;

        @Data
        class FieldsProperties {
            private String type;
            private String placeholder;
            private Boolean required;


        }

    }


}
