package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

@Data
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Components implements Serializable {

    private String internalKey;

    private String label;
    private String title;
    private Boolean allowMultipleMasks;
    private Boolean showWordCount;
    private Boolean showCharCount;
    private Boolean tableView;
    private Boolean alwaysEnabled;
    private String type;
    private Boolean input;
    private String key;
    private Object defaultValue;
    private Validate validate;

    @Data
    static class Validate implements Serializable {
        private String customMessage;
        private String json;
    }

    private Conditional conditional;

    @Data
    static class Conditional implements Serializable {
        private Boolean show;
        private String when;
        private String json;
    }

    private String inputFormat;
    private Boolean encrypted;

    private String customConditional;
    private String format;

    private Widget widget;

    @Data
    static class Widget implements Serializable {
        private String type;
        private String displayInTimezone;
        private String language;
        private Boolean useLocaleSettings;
        private Boolean allowInput;
        private String mode;
        private Boolean enableTime;
        private Boolean noCalendar;
        private String format;
        private String defaultDate;
        private Integer hourIncrement;
        private Integer minuteIncrement;
        private Boolean time_24hr;
        private String minDate;
        private String maxDate;
    }

    private Boolean reorder;

    private Boolean mask;
    private Boolean delimiter;
    private Boolean requireDecimal;
    private Boolean isUploadEnabled;
    private String wysiwyg;
    private String editor;
    private String uploadUrl;
    private String uploadOptions;
    private String uploadDir;
    private String shortcut;
    private String refreshOn;

    private String inputMask;

    private String optionsLabelPosition;

    private Datas data;

    @Data
    static class Datas implements Serializable {
        private List<Values> values;
    }

    private List<Values> values;


    @Data
    static class Values implements Serializable {
        private String label;
        private String value;
        private String shortcut;
    }

    private Boolean inline;
    private String className;
    private Boolean refreshOnChange;

    private String html;

    private Boolean showValidations;
    private String event;
    private String url;
    private String custom;
    private Boolean disableOnInvalid;
    private String theme;

    private String eventType;
    private String buttonKey;

    private GoogleMap map;

    @Data
    static class GoogleMap implements Serializable {
        private String key;
    }

    ;

    private List<Questions> questions;

    @Data
    static class Questions implements Serializable {
        private String label;
        private String value;
    }

    private String storage;
    private String options;
    private String dir;
    private Boolean webcam;
    private String webcamSize;
    private List<FileTypes> fileTypes;

    @Data
    static class FileTypes implements Serializable {
        private String label;
        private String value;
    }

    private String sort;

    private String searchFields;
    private List<Attrs> attrs;

    @Data
    static class Attrs implements Serializable {
        private String attr;
        private String value;
    }

    private String content;

    private String currency;

    private Boolean suffix;

    private DatePicker datePicker;

    @Data
    static class DatePicker implements Serializable {
        private String minDate;
        private String maxDate;
    }

    private Integer nbrRows;

    private Integer width;
    private Integer offset;
    private Integer push;
    private Integer pull;
    private Boolean hideOnChildrenHidden;

    private List<Components> components;
    private List<Components> columns;
    private List<Components> rows;


    private Boolean disableAddingRemovingRows;
    private String addAnother;
    private String addAnotherPosition;
    private String removePlacement;
    private Boolean defaultOpen;
    private Boolean layoutFixed;
    private Boolean enableRowGroups;
    private Boolean groupToggle;
    private ValueComponent valueComponent;

    @Data
    static class ValueComponent implements Serializable {
        private String type;
        private String key;
        private String label;
        private String defaultValue;
        private Boolean input;
        private Boolean tableView;
    }

    private String rowClass;
    private String saveRow;
}
