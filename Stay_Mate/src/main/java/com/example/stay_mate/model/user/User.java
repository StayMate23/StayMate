package com.example.stay_mate.model.user;

import com.example.stay_mate.model.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;
    @JoinColumn(name = "sur_name")
    private java.lang.String surName;
    @JoinColumn(name = "first_name")
    private java.lang.String firstName;
    @JoinColumn(name = "last_name")
    private java.lang.String lastName;
    @JoinColumn(name = "phone_number")
    private java.lang.String phoneNumber;
    @JoinColumn(name = "email")
    private java.lang.String email;
    @JoinColumn(name = "password")
    private java.lang.String password;
    @JoinColumn(name = "personal_id")
    private java.lang.String personalId;
    @JoinColumn(name = "birth_date")
    private LocalDate birthDate;
    @JoinColumn()
    private String role;

    public User(Integer id, java.lang.String surName, java.lang.String firstName, java.lang.String lastName, java.lang.String phoneNumber, java.lang.String email, java.lang.String password, java.lang.String personalId, LocalDate birthDate, String role) {
        this.id = id;
        this.surName = surName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.personalId = personalId;
        this.birthDate = birthDate;
        this.role = role;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getSurName() {
        return surName;
    }

    public void setSurName(java.lang.String surName) {
        this.surName = surName;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public java.lang.String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(java.lang.String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(java.lang.String personalId) {
        this.personalId = personalId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        return Collections.singleton(authority);
    }

    public java.lang.String getPassword() {
        return password;
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

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", personalId='" + personalId + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
