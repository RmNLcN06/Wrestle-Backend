package com.rmnlcn.Wrestle_Backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * Configure les utilisateurs en mémoire avec des rôles.
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password(passwordEncoder().encode("admin123"))
                        .roles("ADMIN")
                        .build(),
                User.withUsername("user")
                        .password(passwordEncoder().encode("user123"))
                        .roles("USER")
                        .build()
        );
    }

    /**
     * Configure la chaîne de sécurité HTTP avec Basic Auth.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Désactiver CSRF pour les tests
                .csrf(AbstractHttpConfigurer::disable)

                // Configurer les autorisations des endpoints
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Swagger public
                        .requestMatchers("/api/continents/**").hasAnyRole("ADMIN", "USER") // CRUD Continents réservé à ADMIN et USER
                        /*.requestMatchers("/api/federations/**").hasRole("ADMIN") // CRUD Federation réservé à ADMIN*/

                        .anyRequest().authenticated() // Authentification nécessaire pour tous les autres endpoints
                )

                // Configurer le gestionnaire d'authentification pour Basic Auth
                .httpBasic(httpBasic -> httpBasic.realmName("Wrestle API"));

        return http.build();
    }

    /**
     * Définit l'encodeur de mot de passe.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Fournit le gestionnaire d'authentification.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

