package org.medipractice.pageservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;

    @Column(nullable = false)
    private String name;

    private String title;

    @JsonIgnore
    @ManyToOne
    private Module module;

    private String icon;

    @Type(type="text")
    private String subTitle;

    @Type(type="text")
    private String schema;
}
