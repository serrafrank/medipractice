package org.medipractice.pageservice.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Type;
import org.medipractice.pageservice.utils.NormalizeName;

import javax.persistence.*;
import java.util.UUID;

@Slf4j
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


    @JsonSetter("module")
    public void setModule(UUID id){
        this.module = new Module();
        this.module.setId(id);
        log.info(this.module.toString());
    }

    @JsonGetter("module")
    public UUID getModule(){
        return this.module.getId();
    }
}
