package com.secucom.secucom.Securite;

import com.secucom.secucom.Models.Collaborateur;
import com.secucom.secucom.Models.Role;
import com.secucom.secucom.Repositories.CollaborateurRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private CollaborateurRepository collaborateurRepository;

    public CustomUserDetailsService(CollaborateurRepository collaborateurRepository) {
        this.collaborateurRepository = collaborateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String NomutilisateurOrEmail) throws UsernameNotFoundException {
        Collaborateur col = collaborateurRepository.findByNomutilisateurOrEmail(NomutilisateurOrEmail, NomutilisateurOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Email ou nom d'utilisateur non trouvé:" + NomutilisateurOrEmail));
        return new org.springframework.security.core.userdetails.User(col.getEmail(),
                col.getPassword(), mapRolesToAuthorities(col.getRoles()));
    }


    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNom())).collect(Collectors.toList());
    }
}
