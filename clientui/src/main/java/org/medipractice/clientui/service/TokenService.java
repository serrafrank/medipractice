package org.medipractice.clientui.service;

import lombok.extern.slf4j.Slf4j;
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


@Service
@Slf4j
public class TokenService extends HttpServlet {


    private final HttpServletRequest request;

    @Autowired
    public TokenService(HttpServletRequest request) {
        this.request = request;
    }


    public String getToken() {

        Optional<String> tokenType = this.readCookie("token_type");
        Optional<String> tokenAccess = this.readCookie("token_access");


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


    private Optional<String> readCookie(String key) {
        Optional<String> value = Optional.empty();

        try{
            value = Arrays.stream(request.getCookies())
                    .filter(c -> key.equals(c.getName()))
                    .map(Cookie::getValue)
                    .findAny();
        }catch (Exception ignore){}

        return value;

    }

    public void removeToken(HttpServletResponse response) {
        Arrays.stream(request.getCookies()).forEach(c -> {
            c.setValue("");
            c.setMaxAge(0);
            response.addCookie(c);
        });
    }
}
