package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.medipractice.formserver.model.Field;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TextareaComponent extends CommonProperties {

    private String type = "textarea";

    private int rows;

    private boolean wysiwyg;



    
}
