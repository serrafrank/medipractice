package org.medipractice.clientui.beans;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class NavigationBean {

    private UUID id;

    private String name;

    private String label;

    private String icon;

    private String page;

    private List<NavigationBean> children;

    private UUID parent;


}
