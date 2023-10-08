package com.herovired.Library.Management.System.SecurityConfigs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class RoleBasedAuthorisation {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        System.out.println("Inside authorization");
        http.authorizeHttpRequests(configure ->
                configure.
                        requestMatchers(HttpMethod.GET, "/user/**").hasRole("USER").
                        requestMatchers(HttpMethod.POST,"/user/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET,"/manager/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET,"/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/public/**").permitAll()
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
