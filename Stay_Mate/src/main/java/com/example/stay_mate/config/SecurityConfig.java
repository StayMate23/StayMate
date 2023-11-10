package com.example.stay_mate.config;


import com.example.stay_mate.service.partner.PartnerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final PartnerService partnerService;

    public SecurityConfig(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(partnerService);
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/partner/reg", "/contact", "/partner/all", "/services", "/add-hotel", "/facilities-list", "facilities-update", "/hotel-list",
                                "/hotel-update", "/new-facilities-form", "/hotels/all", "/hotels/create",
                                "/hotels/new-hotel-form", "hotels/{id}/update").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.logoutSuccessUrl("/")
                        // the row below deleting the cookies
                        .deleteCookies("JSESSIONID")
                        
                );
        return http.build();
    }

}
