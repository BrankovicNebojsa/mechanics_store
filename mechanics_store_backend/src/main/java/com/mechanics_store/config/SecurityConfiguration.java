package com.mechanics_store.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/brands/**").hasAuthority("CLIENT").
                requestMatchers(HttpMethod.POST, "/api/v1/brands/**").hasAuthority("CLIENT")
                .requestMatchers(HttpMethod.GET, "/api/v1/models/**").hasAuthority("CLIENT")
                .requestMatchers(HttpMethod.POST, "/api/v1/models/**").hasAuthority("CLIENT")
                .requestMatchers(HttpMethod.GET, "/api/v1/engines/**").hasAuthority("CLIENT")
                .requestMatchers(HttpMethod.POST, "/api/v1/engines/**").hasAuthority("CLIENT")
                .requestMatchers(HttpMethod.POST, "/api/v1/reservations/**").hasAuthority("CLIENT")
                        
                .requestMatchers(HttpMethod.GET, "/api/v1/reservations/**").hasAuthority("WORKER")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/brands/**").hasAuthority("WORKER")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/cars/**").hasAuthority("WORKER")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/engine/**").hasAuthority("WORKER")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/models/**").hasAuthority("WORKER")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/reservations/**").hasAuthority("WORKER")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/users/**").hasAuthority("WORKER")
                .anyRequest().authenticated())
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
