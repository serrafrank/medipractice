package org.medipractice.clientui.proxies;


import org.medipractice.clientui.beans.menu.MenuBean;
import org.medipractice.clientui.beans.PageBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-page")
public interface PageProxy {

    @GetMapping(value = "/microservice-page/page/{name}")
    PageBean getPage(@PathVariable String name);

    @GetMapping(value = "/microservice-page/menu")
    List<MenuBean> findMenu();

}