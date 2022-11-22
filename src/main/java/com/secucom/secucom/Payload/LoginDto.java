package com.secucom.secucom.Payload;

import lombok.Data;

@Data
public class LoginDto {
    private String nomutilisateurOrEmail;
    private String password;
}
