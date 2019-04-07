package org.medipractice.clientui.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.data.DataFileDto;
import org.medipractice.clientui.proxy.ProxyManager;
import org.medipractice.clientui.service.AbstractService;
import org.medipractice.clientui.service.contract.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service("dataService")
public class DataServiceImpl extends AbstractService implements DataService {

    @Override
    public List<DataFileBean> getDatas(UUID datafile, List<String> datas) {
        return this.proxyManager.getData().getDataFile(this.tokenService.getToken(), datafile);
    }

    @Override
    public List<DataFileBean> getDatas(UUID datafile) {
        return this.proxyManager.getData().getDataFile(this.tokenService.getToken(), datafile);
    }


    @Override
    public DataFileDto postDatas(DataFileDto datas) {

        UUID datafileId = UUID.fromString("77d2f026-0e20-4cc6-9ac4-66c4aa1f214b");
        DataFileDto dataFileDto = new DataFileDto();

        List<DataFileBean> dataFileList = new ArrayList<>();
        datas.getData().forEach((k, v) -> dataFileList.add(new DataFileBean(datafileId, k, v))
        );

        List<DataFileBean> dataFileBeans = this.proxyManager.getData().postDataFile(this.tokenService.getToken(), dataFileList);

        dataFileBeans.forEach(d -> {
            if(d.getType() != null  && d.getValue() != null)
                dataFileDto.getData().put(d.getType(), d.getValue());
        });


        return dataFileDto;

    }

}
