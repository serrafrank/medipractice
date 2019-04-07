package org.medipractice.clientui.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.UserAccountBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.medipractice.clientui.service.AbstractService;
import org.medipractice.clientui.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("userService")
public class UserServiceImpl extends AbstractService implements UserService {

    @Override
    public UserAccountBean getCurrentUser() {
        if(this.tokenService.isConnected())
            return this.proxyManager.getAuth().getCurrent(this.tokenService.getToken());

        return null;
    }
}
