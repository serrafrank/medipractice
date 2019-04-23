package org.medipractice.clientui.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends GenericException {

    private final static String MSG = "Access forbidden";

    public ForbiddenException() {
        super(MSG);
    }

    public ForbiddenException(String message, Throwable cause, boolean enableSuppression,
                              boolean writableStackTrace) {
        super(MSG + " : " + message, cause, enableSuppression, writableStackTrace);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(MSG + " : " + message, cause);
    }

    public ForbiddenException(String message) {
        super(MSG + " : " + message);
    }

    public ForbiddenException(Throwable cause) {
        super(cause);
    }
}
