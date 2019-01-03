package org.medipractice.clientui.beans.menu;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class MenuBean {

    private UUID id;

    private String name;

    private String icon;

    private String page;

    private int order;

    private List<MenuBean> children;

}
