package org.medipractice.datafileserver.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class DataObject extends Auditable<String> {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(nullable = false, unique=true)
    private String dataType;

    @OneToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DataObject> datas = new HashSet<>();
}
