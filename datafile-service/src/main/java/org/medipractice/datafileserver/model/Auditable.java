package org.medipractice.datafileserver.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> implements Serializable {

    @Column( nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    @Column( nullable = false, updatable = false)
    private U createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private U updatedBy;

    private LocalDateTime archivedAt;

    private U archivedBy;


}