package org.medipractice.datafileserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Data
@EqualsAndHashCode(of = {"id", "value", "date"}, callSuper = false)
@ToString(of = {"id", "value", "date"})
@NoArgsConstructor
@Entity
@Table
public class DataValue extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id ;

    @JsonIgnore
    private UUID dataObjectId;

    private UUID parentId ;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    public DataValue(String dataValue) {
        this.value = dataValue;
    }

    public DataValue(DataValue dataValue) {
        this.parentId = dataValue.getParentId();
        this.value = dataValue.getValue();
        this.date = dataValue.getDate();
    }

    public DataValue(String dataValue, LocalDateTime dataDate) {
        this.value = dataValue;
        this.date = dataDate;
    }



}
