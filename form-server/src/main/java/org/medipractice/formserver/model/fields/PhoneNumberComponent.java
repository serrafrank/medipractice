package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PhoneNumberComponent extends CommonProperties {

    private String type = "phonenumber";
    private String inputMask = "99-99-99-99-99";

}
