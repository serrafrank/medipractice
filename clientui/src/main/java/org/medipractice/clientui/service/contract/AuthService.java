package org.medipractice.clientui.service.contract;

import javax.servlet.http.HttpServletResponse;

public interface AuthService {
    void login(String login, String password, HttpServletResponse response);
}
