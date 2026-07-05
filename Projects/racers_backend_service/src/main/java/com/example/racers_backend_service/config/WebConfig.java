package com.example.racers_backend_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Apply to all your API endpoints
                .allowedOrigins("http://localhost:5173") // Allow your exact Vite port
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specifically allow that tricky OPTIONS request!
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}