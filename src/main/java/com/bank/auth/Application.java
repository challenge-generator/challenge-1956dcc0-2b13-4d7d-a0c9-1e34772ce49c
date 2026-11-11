package com.bank.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.bank.auth.infrastructure.config.JwtProperties;

import java.util.TimeZone;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class Application {

    @Value("${app.timezone:UTC}")
    private String timezone;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public void configureTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone(timezone));
    }
}