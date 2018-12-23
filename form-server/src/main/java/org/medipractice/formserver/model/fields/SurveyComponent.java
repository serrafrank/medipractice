package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class SurveyComponent extends CommonProperties {

    private String type = "survey";

    private Map<String, String> questions = new HashMap<>();

    private Map<String, String> values = new HashMap<>();

    
}
