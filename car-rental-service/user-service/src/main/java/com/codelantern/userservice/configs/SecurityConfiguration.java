//package com.codelantern.userservice.configs;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfiguration {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.
//                authorizeHttpRequests(
//                        configure ->
//                                configure.
//                                        requestMatchers("/user/**").hasRole("USER").
//                                        requestMatchers("/public/**").permitAll()
//
//                );
//
//        http.httpBasic(Customizer.withDefaults());
//        http.csrf(AbstractHttpConfigurer::disable);
//        return http.build();
//    }
//}
