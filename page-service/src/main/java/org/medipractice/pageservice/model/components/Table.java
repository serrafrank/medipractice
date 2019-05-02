package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class Table extends AbstractComponent {

    private Integer numRows;
    private Integer numCols;

    private List<Components> rows;

    private List<String> header;
    private Boolean striped;
    private Boolean bordered;
    private Boolean hover;
    private Boolean condensed;

    public Table() {
        this.type = "table";
    }


}
