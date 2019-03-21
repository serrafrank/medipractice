package org.medipractice.clientui.proxy;


import org.medipractice.clientui.beans.page.MenuBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "gateway-server")
@RibbonClient(name = "page-service")
@RequestMapping("api/page")
public interface PageProxy {

    @GetMapping(value = "page/{module}/{name}")
    PageBean getPage( @PathVariable(value = "module") String module, @PathVariable(value = "name") String name);

    @GetMapping(value = "page")
    PageBean getIndex();

    @GetMapping(value = "menu")
    List<MenuBean> findMenu();

    @PostMapping(value = "page")
    ResponseEntity<?> postPage( @RequestBody PageBean Page );

}
