package org.medipractice.clientui.beans.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class ModuleBean  implements Serializable {

    private UUID id;

    private String name;

    private String label;

    private String icon;

    private List<PageBean> pages;

}
