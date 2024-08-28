package com.projet.java.services;
import com.projet.java.models.Utilisateur;
import com.projet.java.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Utilisateur inscrireUtilisateur(Utilisateur utilisateur) {
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        return utilisateurRepository.save(utilisateur);
    }
    @Override
    public Utilisateur connecterUtilisateur(Utilisateur utilisateur) {
        Utilisateur utilisateurExist = utilisateurRepository.findByNomUtilisateur(utilisateur.getNomUtilisateur());
        if (utilisateurExist != null && passwordEncoder.matches(utilisateur.getMotDePasse(), utilisateurExist.getMotDePasse())) {
            return utilisateurExist;
        }
        return null;
    }
}
