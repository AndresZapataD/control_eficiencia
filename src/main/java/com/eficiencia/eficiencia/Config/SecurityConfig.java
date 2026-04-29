package com.eficiencia.eficiencia.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .cors(cors -> {})
        .csrf(csrf -> csrf.disable())
        .httpBasic(httpBasic -> httpBasic.disable())
        .formLogin(form -> form.disable())
        .authorizeHttpRequests(auth -> auth
            // ✅ Login público
            .requestMatchers("/api/auth/**").permitAll()

            // ✅ Preflight (CORS)
            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()


            .anyRequest().authenticated()
        );

    return http.build();
}
}