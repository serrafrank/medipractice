package org.medipractice.clientui.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.CONFLICT)
public final class ConflictException extends GenericException {

    private static final String MSG = "Bad Request Exception";

    public ConflictException() {
        super(MSG);
    }

    public ConflictException(String message, Throwable cause, boolean enableSuppression,
                             boolean writableStackTrace) {
        super( MSG + " : " + message, cause, enableSuppression, writableStackTrace);
    }

    public ConflictException(String message, Throwable cause) {
        super( MSG + " : " + message, cause);
    }

    public ConflictException(String message) {
        super( MSG + " : " + message);
    }

    public ConflictException(Throwable cause) {
        super(cause);
    }
}
