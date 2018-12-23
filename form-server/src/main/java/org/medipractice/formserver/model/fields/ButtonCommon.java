package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ButtonCommon extends CommonProperties {

    private String key = "button";

    private String size;

    private String leftIcon;

    private String rightIcon;

    private String action;

    private boolean disableOnInvalid;

    private String theme;


}
