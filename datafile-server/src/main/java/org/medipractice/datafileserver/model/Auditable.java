package org.medipractice.datafileserver.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column( nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @CreatedBy
    @Column( nullable = false, updatable = false)
    private U createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @LastModifiedBy
    private U updatedBy;

    private boolean archived;

    @Temporal(TemporalType.TIMESTAMP)
    private Date archivedAt;

    private U archivedBy;


}