package com.theskyit.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	registry.addMapping("/**") // Allow all endpoints
                .allowedOriginPatterns("http://127.0.0.1:5500") // Allow all origins (use with caution)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow all HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Disable credentials (if not needed)
            }
            
                
        };
    }
}

