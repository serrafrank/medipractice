package org.medipractice.datafileserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@EqualsAndHashCode(of = {"id", "datas"}, callSuper = false)
@Data
@Entity
@Table
@NoArgsConstructor
public class DataFile extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DataObject> datas = new ArrayList<>();

    public DataObject getDataType(String dataType) {
        return datas.stream()
                .filter(t -> t.getType().equals(dataType))
                .findAny().orElse(null);
    }


    public void setDataType(String dataType, DataValue dataValue){
        datas.add(new DataObject(dataType, dataValue));
    }

    public void setDataType(String dataType, List<DataValue> dataValue){
        datas.add(new DataObject(dataType, dataValue));
    }


}
