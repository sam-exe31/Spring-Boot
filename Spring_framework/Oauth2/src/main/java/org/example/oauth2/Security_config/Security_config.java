package org.example.oauth2.Security_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security_config {

    @Bean
    public SecurityFilterChain securityfilter(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(auth->auth.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults());
        // there are many oauth2 not only google so specify clients in application properties

        return http.build();
    }
}
