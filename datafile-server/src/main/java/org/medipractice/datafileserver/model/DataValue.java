package org.medipractice.datafileserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class DataValue extends Auditable<String> {

    @Id
    private UUID id = UUID.randomUUID();

    private UUID valueId = UUID.randomUUID();

    @Column(nullable = false)
    private String dataValue;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDate;

    private boolean archived;

    @Temporal(TemporalType.TIMESTAMP)
    private Date archivedAt;

    private String archivedBy;
}
