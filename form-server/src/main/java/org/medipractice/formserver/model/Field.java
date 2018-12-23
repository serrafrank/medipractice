package org.medipractice.formserver.model;

import lombok.Data;
import org.medipractice.formserver.model.fields.CommonProperties;

import javax.persistence.*;
import java.util.UUID;

@Data
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    protected CommonProperties fieldType;

    @ManyToOne
    protected FieldCat fieldCat;



}