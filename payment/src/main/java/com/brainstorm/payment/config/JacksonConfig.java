package com.brainstorm.payment.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Register the JavaTimeModule to handle LocalDateTime, LocalDate, etc.
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
