package com.example.stay_mate.service;

import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.service.partner.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomPartnerDetailsService implements UserDetailsService {

    private final PartnerService partnerService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public CustomPartnerDetailsService(PartnerService partnerRepository, PasswordEncoder passwordEncoder) {
        this.partnerService = partnerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Partner partner = partnerService.findByEmail(email);
        if (partner == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        UserDetails userDetails = User.builder()
                .username(email)
                .password(passwordEncoder.encode(partner.getPassword())) // Jelszó
                .roles(partner.getRole().toString()) // Jogosultságok ITT LETT MA 11.13 belejavítja a .toString
                .build();
        return userDetails;
    }

}