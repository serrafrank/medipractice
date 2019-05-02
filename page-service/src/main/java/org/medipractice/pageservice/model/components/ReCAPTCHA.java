package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReCAPTCHA extends AbstractComponent {


    private String eventType;

    public ReCAPTCHA() {
        this.type = "recaptcha";
    }

}
