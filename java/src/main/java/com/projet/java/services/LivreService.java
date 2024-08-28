package com.projet.java.services;

import com.projet.java.models.Livre;

import java.util.List;

public interface LivreService {

    Livre ajouterLivre(Livre livre);

    List<Livre> listerLivres();

    Livre mettreAJourLivre(Long id, Livre livre);

    void supprimerLivre(Long id);
}
