package org.medipractice.clientui.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Slf4j
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public final class ResourceNotFoundException extends GenericException {

    private static final String MSG = "Entity Not Found Exception";

    public ResourceNotFoundException() {
        super(MSG);
    }

    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super( MSG + " : " + message, cause, enableSuppression, writableStackTrace);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super( MSG + " : " + message, cause);
    }

    public ResourceNotFoundException(String message) {
        super( MSG + " : " + message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
