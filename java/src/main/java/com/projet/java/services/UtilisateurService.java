package com.projet.java.services;

import com.projet.java.models.Utilisateur;

public interface UtilisateurService {
    Utilisateur inscrireUtilisateur(Utilisateur utilisateur);
    Utilisateur connecterUtilisateur(Utilisateur utilisateur);
}
