package org.medipractice.clientui.beans.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class DataFileDto {
    private Map<String, String> data = new HashMap<>();
    private Map<String, String> metadata  = new HashMap<>();
    private String state;


}
