package org.medipractice.clientui.proxies;


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
    PageBean getPage(@RequestHeader("Authorization") String token, @PathVariable(value = "module") String module, @PathVariable(value = "name") String name);

    @GetMapping(value = "page")
    PageBean getIndex(@RequestHeader("Authorization") String token);

    @GetMapping(value = "menu")
    List<MenuBean> findMenu(@RequestHeader("Authorization") String token);

    @PostMapping()
    ResponseEntity postPage(@RequestHeader("Authorization") String token, @RequestBody PageBean Page );

}