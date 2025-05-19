package com.filipedevgenz.mssecurity.config;

import com.filipedevgenz.mssecurity.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,jsr250Enabled = true)
public class WebConfig {
   @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
       return http.
               csrf(AbstractHttpConfigurer::disable)
               .formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults())
               .authorizeHttpRequests(authorize -> {
                   authorize.anyRequest()
                           .authenticated();
               })
               .build();
   }

   @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder(10);
   }
}
