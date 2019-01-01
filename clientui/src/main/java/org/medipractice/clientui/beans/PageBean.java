package org.medipractice.clientui.beans;

import lombok.Data;

import java.util.UUID;

@Data
public class PageBean {

    private UUID id;

    private String name;

    private String category;

    private String schema;
}
