package org.medipractice.datafileserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Data
@NoArgsConstructor
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class DataFile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;

    @Column(nullable = false, updatable = false)
    private UUID dataFile;

    @Column(nullable = false, updatable = false)
    private String type;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    @Column( nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    @Column( nullable = false, updatable = false)
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    private LocalDateTime archivedAt;

    private String archivedBy;

    @OneToOne
    private DataFile archived;


    public DataFile(UUID dataFile, String type, String value, LocalDateTime date) {
        this.dataFile = dataFile;
        this.type = type;
        this.value = value;
        this.date = date;
    }
}
