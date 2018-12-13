package org.medipractice.datafileserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

abstract class AbstractController {

    @SuppressWarnings("serial")
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public final class InternalServerError extends RuntimeException {

        public InternalServerError() {
            super();
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

    @SuppressWarnings("serial")
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public final class BadRequestException extends RuntimeException {

        public BadRequestException() {
            super();
        }

        public BadRequestException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

        public BadRequestException(String message, Throwable cause) {
            super(message, cause);
        }

        public BadRequestException(String message) {
            super(message);
        }

        public BadRequestException(Throwable cause) {
            super(cause);
        }
    }

    @SuppressWarnings("serial")
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public final class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException() {
            super();
        }

        public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                         boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

        public ResourceNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public ResourceNotFoundException(String message) {
            super(message);
        }

        public ResourceNotFoundException(Throwable cause) {
            super(cause);
        }
    }

    @SuppressWarnings("serial")
    @ResponseStatus(value = HttpStatus.FOUND)
    public final class ResourceFoundException extends RuntimeException {

        public ResourceFoundException() {
            super();
        }

        public ResourceFoundException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

        public ResourceFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public ResourceFoundException(String message) {
            super(message);
        }

        public ResourceFoundException(Throwable cause) {
            super(cause);
        }

    }

}