package org.medipractice.datafileserver.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Data
@Table
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "type", "dataFileId", "values"}, callSuper = false)
public class DataObject {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String type;

    @JsonIgnore
    private UUID dataFileId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dataObjectId")
    private List<DataValue> values = new ArrayList<>();

    public DataObject(String dataType, List<DataValue> dataValues) {
        this.type = dataType;
        this.values = dataValues;
    }

    public DataObject(String dataType, DataValue dataValues) {
        this.type = dataType;
        this.values = Arrays.asList(dataValues);
    }

    public DataObject(String dataType){
        this.type = dataType;
    }

    public DataValue getValue(UUID id) {
        return values.stream()
                .filter(t -> t.getId().equals(id))
                .findAny().orElse(null);
    }


    public void setValue(DataValue dataValue) {
        UUID uuid = dataValue.getId();
        if(uuid == null){
            values.add(dataValue);
        }else if (getValue(uuid) != null && !getValue(uuid).equals(dataValue) ) {
            archiveValue(uuid);
            dataValue.setParentId(uuid);
            dataValue.setId(UUID.randomUUID());
            values.add(dataValue);
        }
    }


    public void archiveValue(UUID uuid) {
        values.stream()
                .filter(t -> t.getId().equals(uuid))
                .forEach(d -> {
                    d.setArchivedAt(LocalDateTime.now());
                    //ToDo
                    d.setArchivedBy("System");
                });
    }
}
