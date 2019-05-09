package org.medipractice.clientui.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public final class InternalServerError extends GenericException {

    private static final String MSG = "Internal Server Exception";

    public InternalServerError() {
        super(MSG);
    }

    public InternalServerError(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace) {
        super( MSG + " : " + message, cause, enableSuppression, writableStackTrace);
    }

    public InternalServerError(String message, Throwable cause) {
        super( MSG + " : " + message, cause);
    }

    public InternalServerError(String message) {
        super( MSG + " : " + message);
    }

    public InternalServerError(Throwable cause) {
        super(cause);
    }

}
