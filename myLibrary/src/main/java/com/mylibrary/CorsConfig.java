package com.mylibrary;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Adăugați adresa URL a aplicației React
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Adăugați metodele HTTP pe care le permiteți
                .allowedHeaders("*") // Permiteți toate headerele
                .allowCredentials(true); // Permiteți trimiterea de credențiale (cookie-uri, token-uri etc.)
    }
}
