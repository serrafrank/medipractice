package org.medipractice.pageservice.model.components;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class DateTime extends AbstractComponent {

    private String format;
    private Boolean enableDate;
    private Boolean enableTime;
    private String defaultDate;
    private String datepickerMode;
    private DatePicker datePicker;
    private TimePicker timePicker;

    public DateTime() {
        this.type = "datetime";
    }

    @Data
    class DatePicker {
        private Boolean showWeeks;
        private Integer startingDay;
        private String minMode;
        private String maxMode;
        private Integer yearRows;
        private Integer yearColumns;
        private DateTime minDate;
        private DateTime maxDate;
    }

    @Data
    class TimePicker {
        private Integer hourStep;
        private Integer minuteStep;
        private Boolean showMeridian;
        private Boolean readonlyInput;
        private Boolean mousewheel;
        private Boolean arrowkeys;
    }

}
