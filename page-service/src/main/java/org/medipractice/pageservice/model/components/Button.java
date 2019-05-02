package org.medipractice.pageservice.model.components;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class Button extends AbstractComponent {


    private String size;
    private String leftIcon;
    private String rightIcon;
    private Boolean block;
    private String action;
    private Boolean disableOnInvalid;
    private String theme;

    public Button() {
        this.type = "button";
    }

}
