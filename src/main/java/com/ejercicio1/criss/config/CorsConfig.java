package com.ejercicio1.criss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // ✅ Permitir acceso desde cualquier origen
        config.setAllowedOriginPatterns(Arrays.asList("*"));

        // ✅ Permitir métodos HTTP específicos para mayor seguridad
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // ✅ Permitir todos los encabezados
        config.setAllowedHeaders(Arrays.asList("*"));

        // ✅ Permitir credenciales (cookies, tokens, etc.)
        config.setAllowCredentials(true);

        // ✅ Aplicar la configuración solo a las rutas del backend necesarias
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", config);

        return new CorsFilter(source);
    }
}
