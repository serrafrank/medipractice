package org.medipractice.clientui.service.contract;

import org.medipractice.clientui.UserAccountBean;
import org.springframework.stereotype.Service;


public interface UserService {
    UserAccountBean getCurrentUser();
}
