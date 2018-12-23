package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.medipractice.formserver.model.Field;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TableComponent extends CommonProperties {

    private String type = "table";

    private int numRows;

    private int numCols;

    private List<List<Field>> rows = new ArrayList<>();

    private String header;

    private boolean striped;

    private boolean bordered;

    private boolean hover;

    private boolean condensed;



    
}
