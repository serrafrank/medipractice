package org.medipractice.pageservice.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Entity
@Table
@Data
public class Menu {

    @Id
    @Getter
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String label;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Page page;

    private String icon;

    @Column(nullable = false)
    private int sort;

    private boolean root;

    @OneToMany(fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
    private List<Menu> children;

}
