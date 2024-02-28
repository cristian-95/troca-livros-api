package com.cristian.trocalivrosonline.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorizeConfig -> {
                            authorizeConfig.requestMatchers("/auth/signin",
                                    "auth/refresh/**",
                                    "/swagger-ui/**",
                                    "/v3/api-docs/**").permitAll();
                            authorizeConfig.anyRequest().authenticated();
                        })

                .oauth2Login(withDefaults())
                .oauth2ResourceServer(conf -> conf.jwt(withDefaults()))
                .build();
    }
}
