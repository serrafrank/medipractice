package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class SelectBoxComponent extends CommonProperties {

    private String type = "SelectBox";

    private Map<String, String> values = new HashMap<>();

    private boolean inline;

    
}
