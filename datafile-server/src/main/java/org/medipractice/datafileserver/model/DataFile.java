package org.medipractice.datafileserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    @JoinColumn(name = "dataFileId")
    private List<DataObject> datas = new ArrayList<>();


    public DataObject getDataType(String dataType) {
        return datas.stream()
                .filter(t -> t.getType().equals(dataType))
                .findAny().orElse(null);
    }

    public DataObject getIfAbsentPutDataType(String dataType) {
        DataObject dataObject = getDataType(dataType);
        if(dataObject == null){
            dataObject = new DataObject(dataType);
            datas.add(dataObject);
        }

        return dataObject;
    }

}
