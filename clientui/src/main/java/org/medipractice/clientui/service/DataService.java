package org.medipractice.clientui.service;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.data.DataFileDto;
import org.medipractice.clientui.proxy.ProxyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class DataService {

    @Autowired
    private ProxyManager proxyManager;

    @Autowired
    private TokenService tokenService;


    public List<DataFileBean> getDatas(UUID datafile, List<String> datas) {

        return proxyManager.getData().getDataFile(tokenService.getToken(), datafile);

    }

    public List<DataFileBean> getDatas(UUID datafile) {
        return proxyManager.getData().getDataFile(tokenService.getToken(), datafile);
    }

    public DataFileDto postDatas(DataFileDto datas) {

        UUID datafileId = UUID.fromString("77d2f026-0e20-4cc6-9ac4-66c4aa1f214b");
        DataFileDto dataFileDto = new DataFileDto();

        List<DataFileBean> dataFileList = new ArrayList<>();
        datas.getData().forEach((k, v) -> dataFileList.add(new DataFileBean(datafileId, k, v))
        );

        List<DataFileBean> dataFileBeans = proxyManager.getData().postDataFile(tokenService.getToken(), dataFileList);

        dataFileBeans.forEach(d -> {
            if(d.getType() != null  && d.getValue() != null)
                dataFileDto.getData().put(d.getType(), d.getValue());
        });


        return dataFileDto;

    }

}
