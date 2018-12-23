package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DayComponent extends CommonProperties {

    private String type = "day";

    private String fields_day_type;
    private String fields_day_placeholder;
    private boolean fields_day_required;
    private String fields_month_type;
    private String fields_month_placeholder;
    private boolean fields_month_required;
    private String fields_year_type;
    private String fields_year_placeholder;
    private boolean fields_year_required;
    private boolean dayFirst;

    
}
