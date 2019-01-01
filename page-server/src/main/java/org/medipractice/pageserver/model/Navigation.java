package org.medipractice.pageserver.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table
public class Navigation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String name;

    private String label;

    private String icone;

    private String page;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent", cascade = javax.persistence.CascadeType.ALL)
    private List<Navigation> children;

    private UUID parent;


}
