package com.theskyit.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf().disable() //ignoringRequestMatchers("/api/admin/reset-password", "/api/admin/forgot-password") // CSRF protection //CSRF disable (temporarily for development)
        //.and()
        .authorizeHttpRequests()
        
        .anyRequest().permitAll()
//        .and()
//        .formLogin()
//            .permitAll()
        .and()
        .logout()
            .permitAll()
        .and()
        .sessionManagement()
            .maximumSessions(1) // Limit to 1 session per admin user
            .expiredUrl("/api/v1/admin/login?sessionExpired=true") // Redirect to login after session expiration
        .and()
        .sessionFixation().none(); // Avoid unwanted session fixation protection during development
//        http.requiresChannel()
//            .anyRequest()
//            .requiresSecure(); // Force HTTPS for all requests
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12); // For password hashing
    }
}
