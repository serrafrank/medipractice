package org.medipractice.authserver.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class RestInterceptor extends HandlerInterceptorAdapter {
    private long startTime;
    private long endTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        startTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        endTime = System.currentTimeMillis();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        int status = response.getStatus();
        log.info("Request Interceptor - RequestURI : " + request.getMethod() + ":" + request.getRequestURI() + " | Status: " + status + " | RequestTime: "
                + (endTime - startTime) + "ms" );

    }
}