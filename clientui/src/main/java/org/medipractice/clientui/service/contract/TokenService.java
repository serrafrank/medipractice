package org.medipractice.clientui.service.contract;

import org.medipractice.clientui.beans.TokenBean;

import javax.servlet.http.HttpServletResponse;

public interface TokenService {
    void setToken(TokenBean tokenBean, HttpServletResponse response);

    String getToken();

    void removeToken(HttpServletResponse response);

    boolean isConnected();

}
