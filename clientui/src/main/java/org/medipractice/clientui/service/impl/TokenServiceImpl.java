package org.medipractice.clientui.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.TokenBean;
import org.medipractice.clientui.service.AbstractService;
import org.medipractice.clientui.service.contract.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Optional;


@Slf4j
@Service("tokenService")
public class TokenServiceImpl extends AbstractService implements TokenService {

    private final HttpServletRequest request;

    private static final String TOKEN_TYPE = "token_type";

    private static final String TOKEN_ACCESS = "token_access";

    @Autowired
    public TokenServiceImpl(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public boolean isConnected() {
        Optional<String> tokenType = this.readCookie(TOKEN_TYPE);
        Optional<String> tokenAccess = this.readCookie(TOKEN_ACCESS);

        return (tokenType.isPresent() && tokenAccess.isPresent());

    }

    @Override
    public void setToken(TokenBean tokenBean, HttpServletResponse response){

        response.addCookie( new Cookie(TOKEN_ACCESS, tokenBean.getAccessToken()));
        response.addCookie(new Cookie(TOKEN_TYPE, tokenBean.getTokenType()));
    }

    @Override
    public String getToken() {

        Optional<String> tokenType = this.readCookie(TOKEN_TYPE);
        Optional<String> tokenAccess = this.readCookie(TOKEN_ACCESS);

        if (tokenType.isPresent() && tokenAccess.isPresent()) {
            String token = tokenType.get() + " " + tokenAccess.get();
            try {
                return URLDecoder.decode(token, "utf-8");
            } catch (UnsupportedEncodingException e) {
                log.error(e.getMessage());
            }
        }

        return null;
    }

    @Override
    public void removeToken(HttpServletResponse response) {
        log.info("Remove all cookies");
        if (request.getCookies() != null)
            Arrays.stream(this.request.getCookies()).forEach(c -> {
                c.setValue("");
                c.setMaxAge(0);
                response.addCookie(c);
            });
    }



    private Optional<String> readCookie(String key) {
        Optional<String> value = Optional.empty();

        try {
            value = Arrays.stream(this.request.getCookies())
                    .filter(c -> key.equals(c.getName()))
                    .map(Cookie::getValue)
                    .findAny();
        } catch (Exception ignore) {
        }

        return value;

    }
}
