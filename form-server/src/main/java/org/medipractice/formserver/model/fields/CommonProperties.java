package org.medipractice.formserver.model.fields;

import lombok.Data;
import org.medipractice.formserver.model.FieldCat;

import javax.persistence.*;
import java.util.UUID;

@Data
public abstract class CommonProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @Column(unique = true)
    protected String key;

    protected String type;

    protected String label;

    protected String placeholder;

    protected boolean input;

    protected boolean tableView;

    protected boolean isProtected;

    protected String prefix;

    protected String suffix;

    protected String defaultValue;

    protected boolean clearOnHide;

    protected boolean unique;

    protected boolean persistent;

    protected String  validate;

    protected String conditional;

    protected String errors;

    protected String logic;

    protected String properties;
}
