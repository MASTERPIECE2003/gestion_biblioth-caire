package com.projet.java.controllers;

import com.projet.java.models.Utilisateur;
import com.projet.java.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200") // Permet les requêtes depuis cette origine
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/inscription")
    public ResponseEntity<Utilisateur> inscrireUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurInscrit = utilisateurService.inscrireUtilisateur(utilisateur);
        return ResponseEntity.ok(utilisateurInscrit);
    }

    @PostMapping("/connexion")
    public ResponseEntity<Utilisateur> connecterUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurConnecte = utilisateurService.connecterUtilisateur(utilisateur);
        if (utilisateurConnecte != null) {
            return ResponseEntity.ok(utilisateurConnecte);
        } else {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }
}
