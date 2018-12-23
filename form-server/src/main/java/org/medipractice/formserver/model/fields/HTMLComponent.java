package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HTMLComponent extends CommonProperties {

    private String type = "html";

    private String tag;

    private String attrs;

    private String className;

    private String content;



    
}
