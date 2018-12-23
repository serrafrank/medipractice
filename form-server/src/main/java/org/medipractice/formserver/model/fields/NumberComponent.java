package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NumberComponent extends CommonProperties {

    private String type = "number";

    private Float validate_min;

    private Float validate_max;

    private Float validate_step;

    private boolean validate_integer;

    
}
