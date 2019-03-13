package org.medipractice.pageservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.medipractice.pageservice.utils.NormalizeName;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table
@NoArgsConstructor
public class Page {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(cascade = CascadeType.ALL)
    private Module module;

    @Column(nullable = false)
    private String name;

    private String title;

    private String icon;

    @Type(type="text")
    private String subTitle;

    @Type(type="text")
    private String schema;
}
