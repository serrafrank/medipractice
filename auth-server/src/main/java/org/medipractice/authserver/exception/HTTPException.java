package org.medipractice.authserver.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@Data
@EqualsAndHashCode(callSuper = true)
public class HTTPException extends IOException {

    private HttpStatus statusCode;

    public HTTPException(String message)
    {
        super(message);
    }

    public HTTPException(HttpStatus statusCode, String message)
    {
        super(message);
        this.statusCode = statusCode;
    }
}