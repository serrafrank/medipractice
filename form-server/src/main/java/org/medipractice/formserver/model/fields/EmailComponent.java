package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmailComponent extends CommonProperties {

    private String type = "email";

    private boolean kickbox_enabled;

    
}
