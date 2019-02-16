package org.medipractice.clientui.beans.page;

import lombok.Data;

import java.util.UUID;

@Data
public class PageBean {

    private UUID id;

    private static String name;

    private String title;

    private ModuleBean module;

    private String icon;

    private String subTitle;

    private String schema;

}
