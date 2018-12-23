package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CheckboxCommon extends CommonProperties {

    private String key = "checkbox";

    private boolean hideLabel;

    private String datagridLabel;

    private String name;

    private String value;


}
