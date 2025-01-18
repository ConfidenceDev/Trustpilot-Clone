package me.confidencedev.companyservice.config;

import feign.codec.ErrorDecoder;
import me.confidencedev.companyservice.external.decoder.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder(){
        return new CustomErrorDecoder();
    }
}
