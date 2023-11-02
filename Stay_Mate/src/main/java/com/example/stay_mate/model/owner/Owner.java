package com.example.stay_mate.model.owner;

import jakarta.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
}
