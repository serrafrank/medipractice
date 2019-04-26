package org.medipractice.clientui.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.data.DataFileDto;
import org.medipractice.clientui.proxy.ProxyManager;
import org.medipractice.clientui.service.AbstractService;
import org.medipractice.clientui.service.contract.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service("dataService")
public class DataServiceImpl extends AbstractService implements DataService {

    private final HttpServletRequest request;

    @Autowired
    public DataServiceImpl(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public List<DataFileBean> getDatas(UUID datafile, List<String> datas) {
        return this.proxyManager.getData().getDataFile(this.serviceManager.getTokenService().getToken(), datafile);
    }

    @Override
    public List<DataFileBean> getDatas(UUID datafile) {
        return this.proxyManager.getData().getDataFile(this.serviceManager.getTokenService().getToken(), datafile);
    }

    @Override
    public List<DataFileBean> getDatafiles(String[] fields, String value) {
        return this.proxyManager.getData().getDataFiles(this.serviceManager.getTokenService().getToken(), fields,value );
    }

    @Override
    public List<DataFileBean> getAllDatafiles(String[] fields) {
        return this.proxyManager.getData().getAllDataFiles(this.serviceManager.getTokenService().getToken(), fields );
    }

    @Override
    public ResponseEntity<?> setDatafile(UUID value) {
        return null;
    }


    @Override
    public String postNewPatient() {
        return this.proxyManager.getData().postNewPatient(this.serviceManager.getTokenService().getToken());
    }

    @Override
    public DataFileDto postDatas(DataFileDto datas, String datafileId) {


        DataFileDto dataFileDto = new DataFileDto();

        List<DataFileBean> dataFileList = new ArrayList<>();
        datas.getData().forEach((k, v) -> dataFileList.add(new DataFileBean(UUID.fromString(datafileId), k, v))
        );

        List<DataFileBean> dataFileBeans = this.proxyManager.getData().postDataFile(this.serviceManager.getTokenService().getToken(), dataFileList);

        dataFileBeans.forEach(d -> {
            if(d.getType() != null  && d.getValue() != null)
                dataFileDto.getData().put(d.getType(), d.getValue());
        });


        return dataFileDto;

    }

}
