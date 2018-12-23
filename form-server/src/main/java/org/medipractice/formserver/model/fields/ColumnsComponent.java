package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.medipractice.formserver.model.Field;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ColumnsComponent  extends CommonProperties {

    private String type = "columns";

    private List<ColumnsComponent> columns = new ArrayList<>();

    private List<Field> components = new ArrayList<>();

    private int width;

    private int offset;

    private int push;


    private int pull;


}
