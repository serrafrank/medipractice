package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class HTML extends AbstractComponent {

    private String tag;
    private String attrs;
    private String className;
    private String content;

    public HTML() {
        this.type = "HTML";
    }
}
