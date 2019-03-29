package org.medipractice.clientui.service;

import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DataService {

    @Autowired
    private ProxyManager proxyManager;

    @Autowired
    private TokenService tokenService;


    public DataFileBean getDatas(UUID datafile, List<String> datas){

        return proxyManager.getData().getDataFile(tokenService.getToken(), datafile);

    }

    public DataFileBean getDatas(UUID datafile){

        return proxyManager.getData().getDataFile(tokenService.getToken(), datafile);

    }



}
