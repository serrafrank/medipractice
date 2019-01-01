package org.medipractice.clientui.beans;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class Auditable<U> implements Serializable {

    private LocalDateTime createdAt;

    private U createdBy;

    private LocalDateTime updatedAt;

    private U updatedBy;

    private LocalDateTime archivedAt;

    private U archivedBy;


}