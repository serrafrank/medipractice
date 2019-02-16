package org.medipractice.clientui.proxies;


import org.medipractice.clientui.beans.page.MenuBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "gateway-server")
@RequestMapping("api/page")
public interface PageProxy {

    @GetMapping(value = "page/{module}/{name}")
    PageBean getPage(@PathVariable(value = "module") String module, @PathVariable(value = "name") String name);

    @GetMapping(value = "page")
    PageBean getIndex();

    @GetMapping(value = "menu")
    List<MenuBean> findMenu();

}