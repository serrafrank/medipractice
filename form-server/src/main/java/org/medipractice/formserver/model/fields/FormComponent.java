package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormComponent extends CommonProperties {

    private String type = "form";

    private boolean reference;

    private UUID form;

    
}
