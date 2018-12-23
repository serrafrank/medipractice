package org.medipractice.formserver.model.fields;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressCommon extends CommonProperties {

    private String key = "address";

    private String map_region;

    private String map_key;
}
