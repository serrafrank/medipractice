package org.medipractice.pageservice.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.vladmihalcea.hibernate.type.json.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.medipractice.pageservice.model.components.Components;
import org.medipractice.pageservice.model.components.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Data
@Entity
@Table
@NoArgsConstructor
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Page  implements Serializable {

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

    private String display;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Schema schema = new Schema();


    @JsonSetter("module")
    public void setModule(UUID id){
        this.module = new Module();
        this.module.setId(id);
    }

    @JsonGetter("module")
    public UUID getModule(){
        return (this.module != null )?  this.module.getId() : null;
    }
}
