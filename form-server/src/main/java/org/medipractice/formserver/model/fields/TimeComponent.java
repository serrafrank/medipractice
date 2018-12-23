package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TimeComponent extends CommonProperties {

    private String type = "time";

    private String format = "HH:mm";

}
