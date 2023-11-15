/*package com.example.stay_mate.config;

import com.example.stay_mate.service.user.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig {
    private final UserService userService;

    public UserSecurityConfig(UserService userService) {
        this.userService = userService;
    }
    @Bean
    public PasswordEncoder userPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider userDaoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(userPasswordEncoder());
        provider.setUserDetailsService(userService);
        return provider;
    }
    @Bean
    public SecurityFilterChain userFilterChain (HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((authorize)->
                                authorize.requestMatchers("/user-login")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated()
                        )
                .formLogin((formLogin)-> formLogin
                        .loginPage("/user-login")
                        .permitAll()
                ).logout((logout)->logout.logoutSuccessUrl("/"));
        return http.build();
    }
}

 */


