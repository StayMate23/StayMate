package com.example.stay_mate.model.partner;

import com.example.stay_mate.model.Role;
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
    private Role role;

    public Partner(Integer id, java.lang.String partnerName, java.lang.String address, java.lang.String telNum, java.lang.String email, java.lang.String password, Integer companyRegNum, Integer taxNum, Role role) {
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

    public java.lang.String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(java.lang.String partnerName) {
        this.partnerName = partnerName;
    }

    public java.lang.String getAddress() {
        return address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public java.lang.String getTelNum() {
        return telNum;
    }

    public void setTelNum(java.lang.String telephoneNumber) {
        this.telNum = telephoneNumber;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        return Collections.singleton(authority);
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

   public String getName(){
       return this.partnerName;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public java.lang.String toString() {
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
