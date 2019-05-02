package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Data
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Components implements Serializable {

    private String internalKey;


    private String type;
    private String key;
    private String label;
    private String placeholder;
    private Boolean showCharCount;
    private Boolean showWordCount;
    private String allowMultipleMasks;
    private Boolean input;
    private Boolean tableView;
    private Boolean multiple;
    @JsonProperty("protected")
    private Boolean protect;
    private Boolean prefix;
    private Boolean suffix;
    private Boolean clearOnHide;
    private Boolean unique;
    private Boolean persistent;
    private Boolean hidden;
    private Validate validate;
    private Conditional conditional;
    private Errors errors;
    private List<Object> logic;

    private List<Components> components = new ArrayList<>();

    //Address
    private GoogleMap map;


    //Button
    private String size;
    private String leftIcon;
    private String rightIcon;
    private Boolean block;
    private String action;
    private Boolean disableOnInvalid;
    private String theme;


    //Checkbox
    private Boolean hideLabel;
    private String datagridLabel;
    private String name;
    private String value;

    //Columns
    private List<ArrayColumns> columns = new ArrayList<>();

    //Container
    private Boolean tree;

    //Content
    private String html;

    //Currency
    //Custom
    //DataGrid

    //DateTime
    private String format;
    private Boolean enableDate;
    private Boolean enableTime;
    private String defaultDate;
    private String datepickerMode;
    private DatePicker datePicker;
    private TimePicker timePicker;

    //Day
    private Fields fields;
    private Boolean dayFirst;

    //Email
    private Kickbox kickbox;

    //FieldSet
    private String legend;

    //File
    private Boolean image;
    private String imageSize;

    //Form
    private String src;
    private Boolean reference;
    private String form;

    //Hidden

    //HTML
    private String tag;
    private String attrs;
    private String className;
    private String content;


    //Number

    //Panel
    private String title;
//    private String theme;


    //Password

    //PhoneNumber
    private String inputMask;

    // Radio
    private List<Value> values = new ArrayList<>();


    //ReCAPTCHA
    private String eventType;

    //Select
    private String dataSrc;
    private Datas data;
    private String valueProperty;
    private String refreshOn;
    private String filter;
    private Boolean authenticate;
    private String template;

    //SelectBox
//    private List<Value> values = new ArrayList<>();
    private Boolean inline;


    //Signature
    private String footer;
    private String width;
    private String height;
    private String penColor;
    private String backgroundColor;

    //Survey
    private List<Value> questions = new ArrayList<>();
//    private List<Value> values = new ArrayList<>();


    //Table
    private Integer numRows;
    private Integer numCols;

    private List<Components> rows;

    private List<String> header;
    private Boolean striped;
    private Boolean bordered;
    private Boolean hover;
    private Boolean condensed;

    //TextArea
    private Integer nbrRows;
    private String inputFormat;
    private String editor;


    //TextField

    //Time
//    private String format;

    //Well


    @Data
    static class Validate  implements Serializable {
        private String required;
        private String minLength;
        private String maxLength;
        private String pattern;
        private String custom;
        private String customMessage;
        private String json;
        private Integer min;
        private Integer max;
        private String step = "any";
        private Boolean integer;

    }

    @Data
    static class Conditional  implements Serializable {
        private String show;
        private String when;
        private String eq;
        private String json;

    }

    @Data
    static class Errors  implements Serializable {
        private String required;
        private String min;
        private String max;
        private String minLength;
        private String maxLength;
        private String invalid_email;
        private String invalid_date;
        private String pattern;
        private String custom;
    }

    @Data
    class GoogleMap  implements Serializable {
        private String region;
        private String key;
    }


    @Data
    class ArrayColumns  implements Serializable {
        private Integer width;
        private Integer offset;
        private Integer push;
        private Integer pull;


    }

    @Data
    class DatePicker  implements Serializable {
        private Boolean showWeeks;
        private Integer startingDay;
        private String minMode;
        private String maxMode;
        private Integer yearRows;
        private Integer yearColumns;
        private Date minDate;
        private Date maxDate;
    }

    @Data
    class TimePicker  implements Serializable {
        private Integer hourStep;
        private Integer minuteStep;
        private Boolean showMeridian;
        private Boolean readonlyInput;
        private Boolean mousewheel;
        private Boolean arrowkeys;
    }

    @Data
    class Fields  implements Serializable {
        private Fields.FieldsProperties day;
        private Fields.FieldsProperties month;
        private Fields.FieldsProperties year;

        @Data
        class FieldsProperties {
            private String type;
            private String placeholder;
            private Boolean required;


        }

    }

    @Data
    class Kickbox  implements Serializable {
        private Boolean enable;
    }

    @Data
    class Value {
        private String label;
        private String value;
    }

    @Data
    class Datas  implements Serializable {
        private List<Value> values = new ArrayList<>();
        private String url;
        private String resource;
        private String custom;
    }


}
