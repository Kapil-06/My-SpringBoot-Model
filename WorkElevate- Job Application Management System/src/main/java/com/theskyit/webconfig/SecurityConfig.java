package com.theskyit.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf(csrf -> csrf
                .csrfTokenRepository(new HttpSessionCsrfTokenRepository()) // Use HttpSessionCsrfTokenRepository
                .ignoringRequestMatchers("/static/**", "/assets/**", "/api/v1/admin/login", 
                		"/api/v1/admin/logout", "/contact/submit-contact", "/contact/delete-contact/${contactId}", 
                		"/api/v1/job/jobpost-submit", "/api/v1/job/delete-jobpost/${jobId}", "/api/v1/job/modify-jobpost/${jobPostId}", 
                		"/api/v1/candidate/delete-candidate/${jobId}", "/image/upload", "/api/v1/admin/logout", "/full-job-description.html", 
                		"/api/v1/admin/forget-password", "/reset-password") // Ignore CSRF for static resources
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/","/**","/navbar.html","/index.html",  "/static/**", "/assets/**", "/css/**", "/js/**", "/images/**", "/full-job-description.html").permitAll()
                .requestMatchers("/csrf-token").permitAll() 
                .anyRequest().authenticated() // Allow all other requests (temporarily for testing)
            )
            .sessionManagement(session -> session
                .maximumSessions(2)
                .expiredUrl("/api/v1/admin/login?sessionExpired=true")
                .sessionRegistry(sessionRegistry())
            )
            
            .logout(logout -> logout
                .logoutUrl("/api/v1/admin/logout")
                .logoutSuccessUrl("/api/v1/admin/login")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
            )
            .exceptionHandling(exception -> exception
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                System.out.println("Access Denied for URL: " + request.getRequestURI());
                response.sendError(HttpStatus.FORBIDDEN.value(), "Access Denied");
                    })
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}