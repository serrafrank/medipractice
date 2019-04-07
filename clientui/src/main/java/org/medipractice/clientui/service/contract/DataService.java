package org.medipractice.clientui.service.contract;

import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.data.DataFileDto;

import java.util.List;
import java.util.UUID;

public interface DataService {
    List<DataFileBean> getDatas(UUID datafile, List<String> datas);

    List<DataFileBean> getDatas(UUID datafile);

    DataFileDto postDatas(DataFileDto datas);
}
