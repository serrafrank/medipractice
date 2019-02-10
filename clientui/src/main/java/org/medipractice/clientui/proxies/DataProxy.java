package org.medipractice.clientui.proxies;

import org.medipractice.clientui.beans.data.DataFileBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@FeignClient(name = "gateway-server")
@RibbonClient(name = "datafile-business")
@RequestMapping("datafile-service")
public interface DataProxy {

    @GetMapping(value = "datafile/{id}")
    DataFileBean getDataFile(@PathVariable(name = "id") UUID id);

    @PostMapping(value = "datafile/")
    DataFileBean postDataFile(@RequestBody DataFileBean dataFile);

}
