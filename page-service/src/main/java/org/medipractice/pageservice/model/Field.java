package org.medipractice.pageservice.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table
public class Field {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(unique = true)
    private String label;

    @Column(unique = true)
    @Type(type="text")
    private String parameters;

    private String category;

}
