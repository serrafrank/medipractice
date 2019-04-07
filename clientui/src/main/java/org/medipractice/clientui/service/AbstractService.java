package org.medipractice.clientui.service;

import org.medipractice.clientui.proxy.ProxyManager;
import org.medipractice.clientui.service.impl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {
    @Autowired
    protected ProxyManager proxyManager;

    @Autowired
    protected TokenServiceImpl tokenService;

}
