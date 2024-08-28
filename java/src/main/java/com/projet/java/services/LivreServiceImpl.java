package com.projet.java.services;

import com.projet.java.models.Livre;
import com.projet.java.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    @Autowired
    private LivreRepository livreRepository;

    @Override
    public Livre ajouterLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public List<Livre> listerLivres() {
        return livreRepository.findAll();
    }

    @Override
    public Livre mettreAJourLivre(Long id, Livre livre) {
        livre.setId(id);
        return livreRepository.save(livre);
    }

    @Override
    public void supprimerLivre(Long id) {
        livreRepository.deleteById(id);
    }
}
