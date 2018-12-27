package org.medipractice.formserver.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private FormCat formCat;

    private String schema;

}
