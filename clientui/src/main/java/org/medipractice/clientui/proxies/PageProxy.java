package org.medipractice.clientui.proxies;


import org.medipractice.clientui.beans.menu.MenuBean;
import org.medipractice.clientui.beans.menu.SubMenuBean;
import org.medipractice.clientui.beans.PageBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-page", url = "localhost:9091")
public interface PageProxy {

    @GetMapping(value = "page/{name}")
    PageBean getPage(@PathVariable String name);

    @GetMapping(value = "menu")
    List<MenuBean> findMenu();

}