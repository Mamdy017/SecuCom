package com.secucom.secucom.Payload;

import lombok.Data;

@Data
public class SignUpDto {
    private String nom;
    private String prenom;
    private String email;
    private String nomutilisateur;
    private String password;
}
