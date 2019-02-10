package org.medipractice.authserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name="role")
public class Role  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String value;

    @JsonIgnore
    @ManyToMany(targetEntity =Authority.class,fetch = FetchType.EAGER)
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();


}
