package com.dim.Conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@RequiredArgsConstructor
public class ResourceServerConfig {

    //private final PuntoEntradaAutenticacion puntoEntradaAutenticacion;

//    @Bean
//    JwtAuthenticationConverter jwtAuthenticationConverter(){
//        final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName(ROL.toString());
//        jwtGrantedAuthoritiesConverter.setAuthorityPrefix(AUTORIDAD_PREFIJO.toString());
//
//        final JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
//        return jwtAuthenticationConverter;
//    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
               .cors().disable()
               .csrf().disable()
                // TODO: Actvar en producción
//               .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
               .httpBasic().disable()
                .formLogin().disable()
                .authorizeHttpRequests(autorizacion -> autorizacion
                       .requestMatchers(("/swagger-ui/**")).permitAll()
                       .requestMatchers(("/v3/api-docs/**")).permitAll()
                        .requestMatchers(("/auth/**")).permitAll()
                        .anyRequest().permitAll()) // TODO cambiar a autenticado
               .build();
    }


}


