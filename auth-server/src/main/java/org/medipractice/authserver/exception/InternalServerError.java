package org.medipractice.authserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public final class InternalServerError extends GenericException {

    public InternalServerError() {
        super("Internal Server Exception");
    }

    public InternalServerError(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InternalServerError(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerError(String message) {
        super(message);
    }

    public InternalServerError(Throwable cause) {
        super(cause);
    }

}
