package org.medipractice.clientui.proxies;


import org.medipractice.clientui.beans.NavigationBean;
import org.medipractice.clientui.beans.PageBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "microservice-page", url = "localhost:9091")
public interface PageProxy {

    @GetMapping(value = "/Page/{name}")
    PageBean getPage(@PathVariable String name);

    @GetMapping(value = "/Navigation/")
    List<NavigationBean> findAllNavigation();


}