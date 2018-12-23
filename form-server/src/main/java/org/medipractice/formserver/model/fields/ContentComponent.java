package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContentComponent extends CommonProperties {

    private String type = "content";

    private String html;
    
}
