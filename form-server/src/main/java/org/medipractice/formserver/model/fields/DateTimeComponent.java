package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.medipractice.formserver.model.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DateTimeComponent extends CommonProperties {

    private String type = "DateTime";

    private String format = "dd MM yyyy HH:mm";

    private boolean enableDate;
    private boolean enableTime;
    private boolean defaultDate;
    private boolean datepickerMode;
    private boolean datePicker;
    private boolean timePicker;

    private boolean showWeeks;
    private int startingDay;
    private String minMode;
    private String maxMode;
    private int yearRows;
    private int yearColumns;
    private LocalDateTime minDate;
    private LocalDateTime maxDate;

    private int hourStep;
    private int minuteStep;
    private boolean showMeridian = false;
    private boolean readonlyInput;
    private boolean mousewheel;
    private boolean arrowkeys;

}
