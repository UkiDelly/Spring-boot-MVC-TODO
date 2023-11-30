package com.ukidelly.springboot.myfirstapp;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {


    // User 만들기
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        var adminUser = createNewUser("admin", "admin");
        var testUser = createNewUser("test", "test");

        return new InMemoryUserDetailsManager(adminUser, testUser);
    }

    // 새로운 유저를 생성하는 함수
    private UserDetails createNewUser(String username, String password) {
        return User.builder().passwordEncoder(input -> passwordEncoder().encode(input)).username(username).password(password).roles("USER", "ADMIN").build();
    }

    // 비번 인코더
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // H2 콘솔 url을 SpringSecurity에서 해제
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 모든 요청을 승인
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // 승인되지 않은 요청이 오면, formLogin을 호출
        http.formLogin(withDefaults());

        // csrf 비활성화
        http.csrf().disable();

        // frame option 비활성화
        http.headers().frameOptions().disable();


        return http.build();
    }
}
