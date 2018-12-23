package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileComponent extends CommonProperties {

    private String type = "file";

    private boolean image;

    private int imageSize;

    
}
