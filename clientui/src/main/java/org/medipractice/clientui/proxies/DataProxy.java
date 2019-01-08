package org.medipractice.clientui.proxies;

import org.medipractice.clientui.beans.data.DataFileBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;


@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-datafile")
public interface DataProxy {

    @GetMapping(value = "/microservice-datafile/datafile/{id}")
    DataFileBean getDataFile(@PathVariable UUID id);

    @PostMapping(value = "/microservice-datafile/datafile/")
    DataFileBean postDataFile(@RequestBody DataFileBean dataFile);

}
