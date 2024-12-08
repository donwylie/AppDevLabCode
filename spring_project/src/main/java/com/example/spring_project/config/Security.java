package com.example.spring_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class Security {
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        http
                .cors(withDefaults()) // Enable CORS configuration
                .csrf(csrf -> csrf.ignoringRequestMatchers(new MvcRequestMatcher(introspector, "/graphql"))) // Disable CSRF for GraphQL
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll() // Allow H2 Console
                        .requestMatchers(new MvcRequestMatcher(introspector, "/graphql")).permitAll() // Allow GraphQL
                        .requestMatchers(new MvcRequestMatcher(introspector, "/graphiql")).permitAll() // Allow GraphiQL
                        .requestMatchers(new MvcRequestMatcher(introspector, "/api/users/**")).hasRole("ADMIN") // Restrict /api/users to ADMIN
                        .requestMatchers(new MvcRequestMatcher(introspector, "/api/pets/**")).hasAnyRole("ADMIN", "USER") // Restrict /api/pets
                        .requestMatchers(new MvcRequestMatcher(introspector, "/api/households/**")).hasAnyRole("ADMIN", "USER") // Restrict /api/households
                        .anyRequest().authenticated() // All other endpoints require authentication
                )
                .httpBasic(withDefaults()) // Use HTTP Basic authentication
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())); // Allow H2 Console frames

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
    }
}
