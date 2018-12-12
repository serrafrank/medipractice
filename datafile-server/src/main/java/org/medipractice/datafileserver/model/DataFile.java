package org.medipractice.datafileserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class DataFile extends Auditable<String> {
    @Id
    private UUID id = UUID.randomUUID();

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DataObject> datas = new HashSet<>();

    private boolean archived;

    @Temporal(TemporalType.TIMESTAMP)
    private Date archivedAt;

    private String archivedBy;
    

}
