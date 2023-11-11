package com.example.stay_mate.model.bar;

import com.example.stay_mate.model.partner.Partner;
import jakarta.persistence.*;

@Entity
@Table(name = "bar")
public class Bar {
    @JoinColumn(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "name")
    private String name;
    @JoinColumn(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name="partner_id")
    private Partner partner;

    public Bar(Integer id, String name, String description, Partner partner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.partner = partner;
    }

    public Bar() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '}';
    }
}
