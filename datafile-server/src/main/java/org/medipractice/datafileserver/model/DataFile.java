package org.medipractice.datafileserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@EqualsAndHashCode(of = {"id", "datas"}, callSuper = false)
@Data
@Entity
@Table
@NoArgsConstructor
public class DataFile extends Auditable<String>  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dataFileId")
    private List<DataObject> datas = new ArrayList<>();


    public DataObject getDataType(String dataType){
        return datas.stream()
                .filter(t -> t.getType().equals(dataType))
                .findAny().orElse(null);
    }

}
