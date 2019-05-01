package org.medipractice.pageservice.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.medipractice.pageservice.utils.NormalizeName;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Slf4j
@Data
@Entity
@Table
@NoArgsConstructor
@TypeDef(
        name = "jsonb-node",
        typeClass = JsonNodeBinaryType.class
)
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

    @Type( type = "jsonb-node" )
    @Column(columnDefinition = "jsonb")
    private JsonNode schema;


    @JsonSetter("module")
    public void setModule(UUID id){
        this.module = new Module();
        this.module.setId(id);
    }

    @JsonGetter("module")
    public UUID getModule(){
        return this.module.getId();
    }
}
