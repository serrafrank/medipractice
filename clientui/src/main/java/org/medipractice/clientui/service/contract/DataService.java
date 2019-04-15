package org.medipractice.clientui.service.contract;

import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.data.DataFileDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface DataService {
    List<DataFileBean> getDatas(UUID datafile, List<String> datas);

    List<DataFileBean> getDatas(UUID datafile);

    DataFileDto postDatas(DataFileDto datas);

//    List<DataFileBean> getDatafiles(String[] fields, String value);

    List<DataFileBean> getAllDatafiles(String[] fields);

    ResponseEntity<?> setDatafile(UUID value);
}
