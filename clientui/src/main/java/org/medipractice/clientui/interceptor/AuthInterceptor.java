package org.medipractice.clientui.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.TokenBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HttpSession httpSession;

    
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {

        String token  = (httpSession.getAttribute("token") != null) ? httpSession.getAttribute("token").toString() : null;

            if (!request.getRequestURI().equals("/login") && (token == null || response.getStatus() == HttpServletResponse.SC_UNAUTHORIZED)) {
                log.info("------------  Status : " + response.getStatus());
                response.sendRedirect("/login");
                return false;
            }
        return true;
    }

}
