package org.medipractice.datafileserver.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

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

}