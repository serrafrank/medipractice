package org.medipractice.pageservice.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Entity
@Table
@Data
public class Menu {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String label;


    @ManyToOne
    private Module module;

    private String page;

    private String icon;

    @Column(nullable = false)
    private int sort;

    private boolean root;

    @OneToMany(fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
    private List<Menu> children;

}
