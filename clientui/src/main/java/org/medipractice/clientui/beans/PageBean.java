package org.medipractice.clientui.beans;

import lombok.Data;

import java.util.UUID;

@Data
public class PageBean {

    private UUID id;

    private static String name;

    private String title;

    private String subTitle;

    private String schema;

}
