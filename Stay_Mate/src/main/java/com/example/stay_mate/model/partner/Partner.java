package com.example.stay_mate.model.partner;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "partner")
public class Partner implements UserDetails {
    // ROLE-t listába? / ROLE mint enititás / ROLE mint enum
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "partner_name")
    private String partnerName;
    @JoinColumn(name = "address")
    private String address;
    @JoinColumn(name = "tel_num")
    private String telNum;
    @JoinColumn(name = "email")
    private String email;
    @JoinColumn(name = "password")
    private String password;
    @JoinColumn(name = "company_reg_num")
    private Integer companyRegNum;
    @JoinColumn(name = "tax_num")
    private Integer taxNum;
    @JoinColumn(name = "role")
    private String role;

    public Partner(Integer id, String partnerName, String address, String telNum, String email, String password, Integer companyRegNum, Integer taxNum, String role) {
        this.id = id;
        this.partnerName = partnerName;
        this.address = address;
        this.telNum = telNum;
        this.email = email;
        this.password = password;
        this.companyRegNum = companyRegNum;
        this.taxNum = taxNum;
        this.role = role;
    }

    public Partner() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telephoneNumber) {
        this.telNum = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        return Collections.singleton(authority);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
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

    public Integer getCompanyRegNum() {
        return companyRegNum;
    }

    public void setCompanyRegNum(Integer companyRegistrationNumber) {
        this.companyRegNum = companyRegistrationNumber;
    }

    public Integer getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(Integer taxNumber) {
        this.taxNum = taxNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "id=" + id +
                ", partnerName='" + partnerName + '\'' +
                ", address='" + address + '\'' +
                ", telNum='" + telNum + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", companyRegNum=" + companyRegNum +
                ", taxNum=" + taxNum +
                ", role='" + role + '\'' +
                '}';
    }
}
