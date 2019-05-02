package org.medipractice.pageservice.model.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends AbstractComponent {

    private GoogleMap map;

    public Address() {
        this.type = "address";
    }

    @Data
    class GoogleMap {
        private String region;
        private String key;
    }
}
