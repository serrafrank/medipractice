package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContainerComponent extends CommonProperties {

    private String type = "container";

    private boolean tree;

}
