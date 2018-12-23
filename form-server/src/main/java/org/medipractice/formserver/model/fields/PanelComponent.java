package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.medipractice.formserver.model.Field;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PanelComponent extends CommonProperties {

    private String type = "panel";

    private String title;

    private String theme;

    private List<Field> components;

    
}
