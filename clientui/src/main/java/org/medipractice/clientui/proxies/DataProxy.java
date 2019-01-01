package org.medipractice.clientui.proxies;

import org.medipractice.clientui.beans.DataFileBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "microservice-data", url = "localhost:9090")
public interface DataProxy {

    @GetMapping(value = "/DataFile/{id}")
    DataFileBean getDataFile(@PathVariable UUID id);

    @PostMapping(value = "/DataFile/")
    DataFileBean postDataFile(@RequestBody DataFileBean dataFile);

}
