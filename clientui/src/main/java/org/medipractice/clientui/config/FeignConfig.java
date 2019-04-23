package org.medipractice.clientui.config;


import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.medipractice.clientui.exception.BadRequestException;
import org.medipractice.clientui.exception.ErrorResponseDecoder;
import org.medipractice.clientui.exception.ResourceNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {


    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new ErrorResponseDecoder();
    }
}
