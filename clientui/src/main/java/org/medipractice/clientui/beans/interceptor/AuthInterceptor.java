package org.medipractice.clientui.beans.interceptor;

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

        TokenBean tokenBean = (TokenBean) httpSession.getAttribute("token");

        if (tokenBean != null) {
            response.setHeader("Authorization", tokenBean.getTokenType() + " " + tokenBean.getAccessToken());
            log.info("Authorization : " + tokenBean.getTokenType() + " " + tokenBean.getAccessToken());
        }
        return true;
    }

}
