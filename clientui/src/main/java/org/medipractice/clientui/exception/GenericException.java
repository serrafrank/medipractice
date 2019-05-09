package org.medipractice.clientui.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericException extends RuntimeException {

    private static final String MSG = "A CRITICAL ERROR OCCURED";
    
    public GenericException() {
        super(MSG);
        log.error(MSG);
    }

    public GenericException(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace) {
        super( MSG + " : " + message, cause, enableSuppression, writableStackTrace);
        log.error(MSG + " : " + message + " " + cause);
    }

    public GenericException(String message, Throwable cause) {
        super( MSG + " : " + message, cause);
        log.error(MSG + " : " + message + " " + cause.getMessage());
    }

    public GenericException(String message) {
        super( MSG + " : " + message);
        log.error(MSG + " : " + message);
    }

    public GenericException(Throwable cause) {
        super(cause.getLocalizedMessage() + " : " + cause.getMessage(), cause, false, true);
        log.error(MSG + " : " + cause.getMessage(), cause);
    }
}

