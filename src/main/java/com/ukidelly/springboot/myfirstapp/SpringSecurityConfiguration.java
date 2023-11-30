package com.ukidelly.springboot.myfirstapp;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {


    // User 만들기
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        var userDetails = User.builder().passwordEncoder(input -> passwordEncoder().encode(input)).username("admin").password("admin").roles("USER", "ADMIN").build();


        return new InMemoryUserDetailsManager(userDetails);
    }

    // 비번 인코더
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
