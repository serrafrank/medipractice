package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class SignatureComponent extends CommonProperties {

    private String type = "signature";
    private String footer ;
    private int width ;
    private int height ;
    private Color penColor ;
    private Color backgroundColor ;

}
