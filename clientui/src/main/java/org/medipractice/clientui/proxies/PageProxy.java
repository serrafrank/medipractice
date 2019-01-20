package org.medipractice.clientui.proxies;


import org.medipractice.clientui.beans.menu.MenuBean;
import org.medipractice.clientui.beans.PageBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "gateway-server")
@RequestMapping("page-service")
@RibbonClient(name = "page-service")
public interface PageProxy {

    @GetMapping(value = "page/{name}")
    PageBean getPage(@PathVariable(value = "name") String name);

    @GetMapping(value = "menu")
    List<MenuBean> findMenu();

}