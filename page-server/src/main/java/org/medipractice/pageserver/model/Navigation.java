package org.medipractice.pageserver.model;

import lombok.*;
import org.medipractice.pageserver.utils.NormalizeName;

import javax.persistence.*;
import java.text.Normalizer;
import java.util.List;
import java.util.UUID;


@Entity
@Table
@Data
public class Navigation {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private static String name;

    private String label;

    private String icon;

    private String page;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent", cascade = javax.persistence.CascadeType.ALL)
    private List<Navigation> children;

    private UUID parent;

    public void setLabel(String label) {
        this.label = label;
        name = NormalizeName.of(label).toString();

    }

}
