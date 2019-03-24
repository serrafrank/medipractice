package org.medipractice.pageservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table
public class Module {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String label;

    @OneToMany(mappedBy = "module")
    private List<Page> pages;

}
