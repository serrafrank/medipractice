package org.medipractice.clientui.config;


import org.medipractice.clientui.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {


    @Autowired
    private AuthInterceptor authInterceptor;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**") // Be careful : Spring security must not block OPTION
                        .allowedMethods("GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS")
                        .allowedOrigins("*")
                        .allowCredentials(true);
            }
        };
    }
    
    // Static Resource Config
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }
}