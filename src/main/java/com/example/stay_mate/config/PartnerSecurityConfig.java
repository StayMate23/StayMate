package com.example.stay_mate.config;


import com.example.stay_mate.service.partner.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class PartnerSecurityConfig {

    private final PartnerService partnerService;


    @Autowired
    public PartnerSecurityConfig(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider DaoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(partnerService);
        return provider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/hotels/all")
                        .permitAll()
                        .requestMatchers("/partner/**")
                        .permitAll()
                        //.requestMatchers("/user/**")
                        //.permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .permitAll()
                       // .loginPage("/user-login")
                       // .permitAll()
                )
                .logout((logout) -> logout.logoutSuccessUrl("/")
                        .deleteCookies("JSESSIONID"));
        return http.build();
    }
/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/login", "/reg").permitAll()
                .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/partner").hasAnyRole("ADMIN")
                .and()
                .formLogin().defaultSuccessUrl("/user").permitAll()
                .successHandler((request, response, authentication) -> {
                    for (GrantedAuthority authority : authentication.getAuthorities()) {
                        if (authority.getAuthority().equals("ROLE_ADMIN")) {
                            response.sendRedirect("/admin");
                        } else if (authority.getAuthority().equals("ROLE_USER")) {
                            response.sendRedirect("/user");
                        }
                    }
                })
                .and()
                .logout()
                .logoutUrl("/logout") // Kijelentkezés URL-je
                .logoutSuccessUrl("/") // Kijelentkezés utáni átirányítás
                .permitAll();
        return http.build();
    }



    @Bean
    public SecurityFilterChain userFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/", "/user-login")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/user-login")
                        .permitAll()
                ).logout((logout) -> logout.logoutSuccessUrl("/"));
        return http.build();
    } */
}
