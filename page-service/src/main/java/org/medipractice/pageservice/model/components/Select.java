package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class Select extends AbstractComponent {

    private String dataSrc;
    private Datas data;
    private String valueProperty;
    private String refreshOn;
    private String filter;
    private Boolean authenticate;
    private String template;


    public Select() {
        this.type = "select";
    }


    @Data
    class Datas {
        private List<Value> values = new ArrayList<>();
        private String url;
        private String resource;
        private String custom;
    }

    @Data
    class Value {
        private String label;
        private String value;
    }
}
