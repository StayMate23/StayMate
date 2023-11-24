package com.example.stay_mate.service;

import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.model.user.User;
import com.example.stay_mate.service.partner.PartnerService;
import com.example.stay_mate.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomPartnerDetailsService implements UserDetailsService {

    private final PartnerService partnerService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public CustomPartnerDetailsService(PartnerService partnerService, UserService userService, PasswordEncoder passwordEncoder) {
        this.partnerService = partnerService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

  /*  @Override
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

   */

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
     //   User user = userService.findByEmail(email);
     //   if (user!=null){
     //       UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
     //               .username(email)
     //               .password(passwordEncoder.encode(user.getPassword()))
     //               .roles(user.getRole().toString())
     //               .build();
     //       return userDetails;
     //   }
        Partner partner = partnerService.getPartnerByEmail(email);
        if (partner!=null){
            UserDetails partnerDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(email)
                    .password(passwordEncoder.encode(partner.getPassword()))
                    .roles(partner.getRole().toString())
                    .build();
            return partnerDetails;
        }
        throw new UsernameNotFoundException("User not foud: " + email);
    }

}
