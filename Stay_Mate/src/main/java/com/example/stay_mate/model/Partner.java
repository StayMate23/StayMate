package com.example.stay_mate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "partner")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @JoinColumn(name = "partner_name")
    String partnerName;
    @JoinColumn(name = "address")
    String address;
    @JoinColumn(name = "tel_num")
    String telNum;
    @JoinColumn(name = "email")
    String email;
    @JoinColumn(name = "company_reg_num")
    Integer companyRegNum;
    @JoinColumn(name = "tax_num")
    Integer taxNum;

    public Partner(Integer id, String partnerName, String address, String telNum, String email, Integer companyRegNum, Integer taxNum) {
        this.id = id;
        this.partnerName = partnerName;
        this.address = address;
        this.telNum = telNum;
        this.email = email;
        this.companyRegNum = companyRegNum;
        this.taxNum = taxNum;
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

    @Override
    public String toString() {
        return "Partner{" +
                "id=" + id +
                ", partnerName='" + partnerName + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telNum + '\'' +
                ", email='" + email + '\'' +
                ", companyRegistrationNumber=" + companyRegNum +
                ", taxNumber=" + taxNum +
                '}';
    }
}
