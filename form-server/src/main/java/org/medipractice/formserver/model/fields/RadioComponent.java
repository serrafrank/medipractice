package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class RadioComponent extends CommonProperties {

    private String type = "radio";

    private Map<String, String> values = new HashMap<>();

    
}
