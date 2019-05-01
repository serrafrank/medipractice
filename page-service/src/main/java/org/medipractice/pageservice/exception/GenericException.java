package org.medipractice.pageservice.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericException extends RuntimeException {

    public GenericException() {
        super("A CRITICAL ERROR OCCURED");
        log.error("A CRITICAL ERROR OCCURED");
    }

    public GenericException(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error("A CRITICAL ERROR OCCURED : " + message + " " + cause);
    }

    public GenericException(String message, Throwable cause) {
        super(message, cause);
        log.error("A CRITICAL ERROR OCCURED : " + message + " " + cause.getMessage());
    }

    public GenericException(String message) {
        super(message);
        log.error("A CRITICAL ERROR OCCURED : " + message);
    }

    public GenericException(Throwable cause) {
        super(cause.getLocalizedMessage() + " : " + cause.getMessage(), cause, false, true);
        log.error("A CRITICAL ERROR OCCURED : " + cause.getMessage(), cause);
    }
}

