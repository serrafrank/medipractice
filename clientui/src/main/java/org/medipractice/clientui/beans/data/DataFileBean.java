package org.medipractice.clientui.beans.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class DataFileBean {

    private UUID id;

    private UUID dataFile;

    private String type;

    private String value;

    private LocalDateTime date = LocalDateTime.now();

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private LocalDateTime archivedAt;

    private String archivedBy;


    public DataFileBean(UUID dataFile, String type, String value) {
        this.dataFile = dataFile;
        this.type = type;
        this.value = value;
    }
}
