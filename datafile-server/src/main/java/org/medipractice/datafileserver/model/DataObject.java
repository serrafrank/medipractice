package org.medipractice.datafileserver.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@Table
@Entity
@NoArgsConstructor
public class DataObject {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String type;

    @JsonIgnore
    private UUID dataFileId;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dataObjectId")
    private List<DataValue> values = new ArrayList<>();

    public DataObject(String dataType, List<DataValue> dataValues) {
        this.type = dataType;
        this.values = dataValues;
    }
}
