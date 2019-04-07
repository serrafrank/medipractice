package org.medipractice.clientui.service.contract;

import javax.servlet.http.HttpServletResponse;

public interface TokenService {
    String getToken();

    void removeToken(HttpServletResponse response);

    boolean isConnected();

}
