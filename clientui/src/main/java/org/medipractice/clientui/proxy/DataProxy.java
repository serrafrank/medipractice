package org.medipractice.clientui.proxy;

import org.medipractice.clientui.beans.data.DataFileBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@FeignClient(name = "gateway-server")
@RibbonClient(name = "datafile-service")
@RequestMapping("api/datafile")
public interface DataProxy {

    @GetMapping(value = "{id}")
    List<DataFileBean> getDataFile(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable(name = "id") UUID id);

    @PostMapping
    List<DataFileBean> postDataFile(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody List<DataFileBean> dataFile);

    @GetMapping(value = "{types}/{value}")
    List<DataFileBean> getDataFiles(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable(name = "types") String[] types, @PathVariable(name = "value") String value );

}
