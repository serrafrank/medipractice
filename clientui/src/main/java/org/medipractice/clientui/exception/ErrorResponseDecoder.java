package org.medipractice.clientui.exception;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.*;
import org.medipractice.clientui.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.xml.ws.Service;
import java.io.*;

public class ErrorResponseDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Autowired
    private ServiceManager serviceManager;


    @Override
    public Exception decode(String s, Response response) {

        String message = null;
        Reader reader = null;

        try {
            reader = response.body().asReader();
            //Easy way to read the stream and get a String object
            String result = CharStreams.toString(reader);
            //use a Jackson ObjectMapper to convert the Json String into a
            //Pojo
            ObjectMapper mapper = new ObjectMapper();
            //just in case you missed an attribute in the Pojo
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            //init the Pojo
            ExceptionMessage exceptionMessage = mapper.readValue(result,
                    ExceptionMessage.class);

            message = exceptionMessage.message;

        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            //It is the responsibility of the caller to close the stream.
            try {

                if (reader != null)
                    reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        switch (response.status()) {
            case 400:
                return new BadRequestException(message);
            case 401:
                return new UnauthorizedException(message);
            case 403:
                return new ForbiddenException(message);
            case 404:
                return new ResourceNotFoundException(message);
            case 406:
                return new NotSupportedException(message);
            case 409:
                return new ConflictException(message);
            case 500:
                return new InternalServerError(message);
        }
        return errorDecoder.decode(s, response);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ExceptionMessage {

        private String timestamp;
        private int status;
        private String error;
        private String message;
        private String path;

    }
}
