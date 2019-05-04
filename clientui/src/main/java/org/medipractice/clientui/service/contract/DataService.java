package org.medipractice.clientui.service.contract;

import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.data.DataFileDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface DataService {
    List<DataFileBean> getDatas(UUID datafile, Set<String> datas);

    List<DataFileBean> getDatas(UUID datafile);

    DataFileDto postDatas(DataFileDto datas, String datafileId);

    List<DataFileBean> getDatafiles(String[] fields, String value);

    List<DataFileBean> getAllDatafiles(String[] fields);

    ResponseEntity<?> setDatafile(UUID value);

    String postNewPatient();
}
