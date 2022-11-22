package com.secucom.secucom.Repositories;

import com.secucom.secucom.Models.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Long > {
    Optional<Collaborateur> findByEmail(String email);
    Optional<Collaborateur> findByNomutilisateurOrEmail(String nomutilisateur, String email);
    Optional<Collaborateur> findByNomutilisateur(String nomUtilisateur);
    Boolean existsByNomutilisateur(String nomutilisateur);
    Boolean existsByEmail(String email);
}
