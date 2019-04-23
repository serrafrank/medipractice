package org.medipractice.clientui.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends GenericException {

    private static final String MSG = "Access Not Authorized";

    public UnauthorizedException() {
        super(MSG);
    }

    public UnauthorizedException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super( MSG + " : " + message, cause, enableSuppression, writableStackTrace);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super( MSG + " : " + message, cause);
    }

    public UnauthorizedException(String message) {
        super( MSG + " : " + message);
    }

    public UnauthorizedException(Throwable cause) {
        super(cause);
    }
}
