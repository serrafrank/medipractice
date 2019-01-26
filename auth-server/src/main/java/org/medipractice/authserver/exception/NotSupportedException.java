package org.medipractice.authserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NotSupportedException extends GenericException {

        public NotSupportedException() {
            super("Not Supported Exception");
        }

        public NotSupportedException(String message, Throwable cause, boolean enableSuppression,
                                         boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

        public NotSupportedException(String message, Throwable cause) {
            super(message, cause);
        }

        public NotSupportedException(String message) {
            super(message);
        }

        public NotSupportedException(Throwable cause) {
            super(cause);
        }
}
