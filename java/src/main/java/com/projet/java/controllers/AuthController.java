package com.projet.java.controllers;

import com.projet.java.models.Utilisateur;
import com.projet.java.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200") // Permet les requêtes depuis cette origine
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/inscription")
    public Utilisateur inscrireUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.inscrireUtilisateur(utilisateur);
    }

    @PostMapping("/connexion")
    public Utilisateur connecterUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.connecterUtilisateur(utilisateur);
    }
}
