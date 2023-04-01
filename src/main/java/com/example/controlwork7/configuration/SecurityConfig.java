package com.example.controlwork7.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers(HttpMethod.POST,"/tasks").fullyAuthenticated();
//        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/tasks").fullyAuthenticated();
//        http.authorizeRequests().antMatchers(HttpMethod.GET, "/tasks/**").fullyAuthenticated();
//        http.authorizeRequests().antMatchers(HttpMethod.GET, "/tasks").fullyAuthenticated();


        http.authorizeRequests()
                .anyRequest()
                .permitAll();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.httpBasic();
        http.formLogin().disable().logout().disable();
        http.csrf().disable();
    }
}
