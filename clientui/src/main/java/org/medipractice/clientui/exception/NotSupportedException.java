package org.medipractice.clientui.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NotSupportedException extends GenericException {

    private static final String MSG = "Not Supported Exception";

    public NotSupportedException() {
        super(MSG);
    }

    public NotSupportedException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super( MSG + " : " + message, cause, enableSuppression, writableStackTrace);
    }

    public NotSupportedException(String message, Throwable cause) {
        super( MSG + " : " + message, cause);
    }

    public NotSupportedException(String message) {
        super( MSG + " : " + message);
    }

    public NotSupportedException(Throwable cause) {
        super(cause);
    }
}
