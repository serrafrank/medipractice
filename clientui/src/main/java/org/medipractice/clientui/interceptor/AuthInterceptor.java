package org.medipractice.clientui.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        Cookie cookie = WebUtils.getCookie(request, "token");

        log.info("------------  Status : " + response.getStatus());

        if (!request.getRequestURI().equals("/login") && (cookie == null || response.getStatus() == HttpServletResponse.SC_UNAUTHORIZED)) {



            if(cookie != null)
                new Cookie("token", "");

            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}
