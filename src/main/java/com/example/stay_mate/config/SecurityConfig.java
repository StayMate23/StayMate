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
                        .requestMatchers("/","/partner/reg", "/partner/all",
                                "/hotel-list","/hotel-update", "/hotels/all","/hotels/create","/add-hotel",
                                "/hotels/new-hotel-form","hotels/{id}/update",
                                "/message","/contact",
                                "/bars/create","/bars/current","/bars/delete","bars/all",
                                "/restaurants/all","/restaurants/create",
                                "/room")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) ->logout.logoutSuccessUrl("/"));
        return http.build();
    }

}
