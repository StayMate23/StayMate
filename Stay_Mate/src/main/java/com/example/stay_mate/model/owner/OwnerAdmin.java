package com.example.stay_mate.model.owner;

import jakarta.persistence.*;

@Entity
@Table(name = "owner_admin")
public class OwnerAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
}
