package org.medipractice.pageserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table
@NoArgsConstructor
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String name;

    @Type(type="text")
    private String schema;

    public Page(String name, String schema) {
        this.name = name;
        this.schema = schema;
    }
}
