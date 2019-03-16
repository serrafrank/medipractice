package org.medipractice.clientui.beans.page;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class MenuBean {

    private UUID id;

    private String label;

    private String icon;

    private PageBean page;

    private int sort;

    private boolean root;

    private List<MenuBean> children;

}
