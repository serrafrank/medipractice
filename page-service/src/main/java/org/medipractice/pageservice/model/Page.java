package org.medipractice.pageservice.model;

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
    private UUID id;

    @ManyToOne
    private Module module;

    private String name;

    private String title;

    private String icon;

    @Type(type="text")
    private String subTitle;

    @Type(type="text")
    private String schema;

    public Page(String title, String subTitle, String schema) {
        this.title = title;
        this.subTitle = subTitle;
        this.schema = schema;
    }

    public void getTitle(String title){
        this.title = title;
        this.name = NormalizeName.of(title).toString();
    }


}
