package org.medipractice.formserver.model;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table
public class FieldCat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String name;

    private String groupe;

    private String label;

    private String description;

    private String type = "base";
}
