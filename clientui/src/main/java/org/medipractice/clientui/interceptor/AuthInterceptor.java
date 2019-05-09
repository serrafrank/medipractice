package org.medipractice.clientui.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.service.impl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenServiceImpl tokenService;

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {

        String token = tokenService.getToken();

        if (!request.getRequestURI().equals("/login") && (token == null|| response.getStatus() == HttpServletResponse.SC_FORBIDDEN || response.getStatus() == HttpServletResponse.SC_UNAUTHORIZED)) {

            if(token != null) {
                tokenService.removeToken(response);
            }

            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}
