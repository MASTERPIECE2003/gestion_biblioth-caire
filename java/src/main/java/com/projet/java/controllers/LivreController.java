package com.projet.java.controllers;
import com.projet.java.models.Livre;
import com.projet.java.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/livres")
@CrossOrigin(origins = "http://localhost:4200") // Permet les requêtes depuis cette origine
public class LivreController {
    @Autowired
    private LivreService livreService;
    @PostMapping
    public ResponseEntity<Livre> ajouterLivre(@RequestBody Livre livre) {
        Livre nouveauLivre = livreService.ajouterLivre(livre);
        return ResponseEntity.ok(nouveauLivre);
    }
    @GetMapping
    public ResponseEntity<List<Livre>> listerLivres() {
        List<Livre> livres = livreService.listerLivres();
        return ResponseEntity.ok(livres);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livre> mettreAJourLivre(@PathVariable Long id, @RequestBody Livre livre) {
        Livre livreMisAJour = livreService.mettreAJourLivre(id, livre);
        return ResponseEntity.ok(livreMisAJour);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerLivre(@PathVariable Long id) {
        livreService.supprimerLivre(id);
        return ResponseEntity.noContent().build();
    }
}
