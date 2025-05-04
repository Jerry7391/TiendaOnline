/*package tienda_online.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Habilitar CSRF con tokens almacenados en cookies
                .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                // Configurar CORS para permitir solo dominios específicos
                .cors(cors -> cors.configurationSource(request -> {
                    var config = new org.springframework.web.cors.CorsConfiguration();
                    config.setAllowedOrigins(List.of("GET http://localhost:8080/saludo")); // Cambia por tu dominio
                    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                    config.setAllowedHeaders(List.of("Authorization", "Content-Type"));
                    return config;
                }))
                // Configurar autorización de rutas
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // Permitir acceso público a ciertas rutas
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Rutas protegidas para administradores
                        .anyRequest().authenticated() // Requiere autenticación para el resto
                )
                // Requerir HTTPS para todas las solicitudes
                .requiresChannel(channel -> channel.anyRequest().requiresSecure())
                // Configurar cabeceras de seguridad
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::deny)
                        .httpStrictTransportSecurity(hsts -> hsts.includeSubDomains(true).maxAgeInSeconds(31536000))
                        .addHeaderWriter((request, response) ->
                                response.addHeader("Content-Security-Policy", "default-src 'self'; img-src 'self'; style-src 'self'; font-src 'self'; connect-src 'self';")
                        )
                        .addHeaderWriter((request, response) ->
                                response.addHeader("Permissions-Policy", "geolocation=(), microphone=(), camera=()")
                        )
                        .addHeaderWriter((request, response) ->
                                response.addHeader("X-Content-Type-Options", "nosniff")
                        )
                        .referrerPolicy(referrer -> referrer.policy(ReferrerPolicyHeaderWriter.ReferrerPolicy.NO_REFERRER))
                )
                // Configurar gestión de sesiones
                .sessionManagement(session -> session
                        .sessionFixation().migrateSession()
                        .maximumSessions(1).maxSessionsPreventsLogin(true)
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Usar BCrypt para cifrar contraseñas
        return new BCryptPasswordEncoder();
    }
}*/