package org.medipractice.datafileserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@Entity
@Table
public class DataValue extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;

    @JsonIgnore
    private UUID dataObjectId;

    private UUID parentId ;

    @Column(nullable = false)
    private String dataValue;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDate = new Date();

    public DataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public DataValue(String dataValue, Date dataDate) {
        this.dataValue = dataValue;
        this.dataDate = dataDate;
    }



}
