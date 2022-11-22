package com.secucom.secucom.Models;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String nom;
}
