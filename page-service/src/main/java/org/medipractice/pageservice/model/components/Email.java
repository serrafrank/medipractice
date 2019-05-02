package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class Email extends AbstractComponent {

    private Kickbox kickbox;

    public Email() {
        this.type = "email";
    }

    @Data
    class Kickbox {
        private Boolean enable;
    }
}
