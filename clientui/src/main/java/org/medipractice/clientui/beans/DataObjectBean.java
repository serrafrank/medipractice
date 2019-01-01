package org.medipractice.clientui.beans;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(of = {"id", "type", "dataFileId", "values"}, callSuper = false)
public class DataObjectBean {

    private UUID id;

    private String type;

    private UUID dataFileId;

    private List<DataValueBean> values = new ArrayList<>();

    public DataObjectBean(String dataType, List<DataValueBean> dataValueBeans) {
        this.type = dataType;
        this.values = dataValueBeans;
    }

    public DataObjectBean(String dataType, DataValueBean dataValuesBean) {
        this.type = dataType;
        this.values = Arrays.asList(dataValuesBean);
    }

    public DataObjectBean(String dataType) {
        this.type = dataType;
    }

    public DataValueBean getValue(UUID id) {
        return values.stream()
                .filter(t -> t.getId().equals(id))
                .findAny().orElse(null);
    }

}
