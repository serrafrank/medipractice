package org.medipractice.pageserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.medipractice.pageserver.utils.NormalizeName;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table
@NoArgsConstructor
public class Page {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Getter
    @Column(unique = true)
    private String name;

    private String title;

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
