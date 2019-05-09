package org.medipractice.clientui.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class BadRequestException extends GenericException {

    private final static String MSG = "Bad Request Exception";

    public BadRequestException() {
        super(MSG);
    }

    public BadRequestException(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace) {
        super( MSG + " : " + message, cause, enableSuppression, writableStackTrace);
    }

    public BadRequestException(String message, Throwable cause) {
        super( MSG + " : " + message, cause);
    }

    public BadRequestException(String message) {
        super( MSG + " : " + message);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }
}
