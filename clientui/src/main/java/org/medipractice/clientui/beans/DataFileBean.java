package org.medipractice.clientui.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class DataFileBean extends Auditable<String> {

    private UUID id;
    private List<DataObjectBean> datas = new ArrayList<>();

    public DataObjectBean getDataType(String dataType) {
        return datas.stream()
                .filter(t -> t.getType().equals(dataType))
                .findAny().orElse(null);
    }

    public void setDataType(String dataType, DataValueBean dataValueBean){
        datas.add(new DataObjectBean(dataType, dataValueBean));
    }

    public void setDataType(String dataType, List<DataValueBean> dataValueBean){
        datas.add(new DataObjectBean(dataType, dataValueBean));
    }


}
