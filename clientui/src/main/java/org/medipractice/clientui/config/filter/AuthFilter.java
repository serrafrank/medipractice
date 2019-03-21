package org.medipractice.clientui.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;

@Slf4j
@Component
@Order(1)
public class AuthFilter implements Filter {


    @Override
    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(httpServletRequest);

        Cookie token = WebUtils.getCookie(httpServletRequest, "token");

        if (token != null) {
            log.info("Token : " + token.getValue());
            mutableRequest.putHeader("Authorization", "bearer " + URLDecoder.decode(token.getValue(), "utf-8"));
        }

        chain.doFilter(mutableRequest, response);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    public class MutableHttpServletRequest extends HttpServletRequestWrapper {
        // holds custom header and value mapping
        private final Map<String, String> customHeaders;

        public MutableHttpServletRequest(HttpServletRequest request) {
            super(request);
            this.customHeaders = new HashMap<String, String>();
        }

        public void putHeader(String name, String value) {
            this.customHeaders.put(name, value);
        }

        public String getHeader(String name) {
            // check the custom headers first
            String headerValue = customHeaders.get(name);

            if (headerValue != null) {
                return headerValue;
            }
            // else return from into the original wrapped object
            return ((HttpServletRequest) getRequest()).getHeader(name);
        }

        public Enumeration<String> getHeaderNames() {
            // create a set of the custom header names
            Set<String> set = new HashSet<String>(customHeaders.keySet());

            // now add the headers from the wrapped request object
            Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
            while (e.hasMoreElements()) {
                // add the names of the request headers into the list
                String n = e.nextElement();
                set.add(n);
            }

            // create an enumeration from the set and return
            return Collections.enumeration(set);
        }
    }

}
