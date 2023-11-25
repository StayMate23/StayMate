package com.example.stay_mate.model.partner;

import com.example.stay_mate.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "partner")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Partner implements UserDetails {
    // ROLE-t listába? / ROLE mint enititás / ROLE mint enum
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "partner_name")
    private String partnerName;
    @JoinColumn(name = "address")
    private java.lang.String address;
    @JoinColumn(name = "tel_num")
    private java.lang.String telNum;
    @JoinColumn(name = "email")
    private java.lang.String email;
    @JoinColumn(name = "password")
    private java.lang.String password;
    @JoinColumn(name = "company_reg_num")
    private Integer companyRegNum;
    @JoinColumn(name = "tax_num")
    private Integer taxNum;
    @JoinColumn(name = "role")
    @Column(columnDefinition = "ENUM('ADMIN','USER')")
    @Enumerated(EnumType.STRING)


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_PARTNER");
        return Collections.singleton(authority);
    }

    @Override
    public java.lang.String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
