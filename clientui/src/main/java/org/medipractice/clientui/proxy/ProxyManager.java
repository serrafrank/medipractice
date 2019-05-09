package org.medipractice.clientui.proxy;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ProxyManager {

    @Autowired
    private PageProxy page;

    @Autowired
    private DataProxy data;

    @Autowired
    private AuthProxy auth;



}
