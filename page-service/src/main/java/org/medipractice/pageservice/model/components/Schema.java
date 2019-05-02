package org.medipractice.pageservice.model.components;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Schema implements Serializable {
    private String display;
    private List<Components> components = new ArrayList<>();
}
