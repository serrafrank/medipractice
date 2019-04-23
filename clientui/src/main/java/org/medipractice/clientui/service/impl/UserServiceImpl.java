package org.medipractice.clientui.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.UserAccountBean;
import org.medipractice.clientui.service.AbstractService;
import org.medipractice.clientui.service.contract.UserService;
import org.springframework.stereotype.Service;

@Slf4j
@Service("userService")
public class UserServiceImpl extends AbstractService implements UserService {

    @Override
    public UserAccountBean getCurrentUser() {
        if(this.serviceManager.getTokenService().isConnected())
            return this.proxyManager.getAuth().getCurrent(this.serviceManager.getTokenService().getToken()).getBody();

        return null;
    }
}
