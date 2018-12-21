package com.insat.bibliotheque.service;

import com.insat.bibliotheque.domain.Livre;
import com.insat.bibliotheque.repository.LivreRepository;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LivreService {


    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }


    public Livre save(Livre livre) {
            return livreRepository.save(livre);
    }

    @Transactional(readOnly = true)
    public List<Livre> findAll() {
        return livreRepository.findAll();
    }


    @Transactional(readOnly = true)
    public List<Livre> findByGenre(String genre) {
        return livreRepository.findByGenree(genre);
    }

    @Transactional(readOnly = true)
    public List<Livre> findByAlphabet(String alphabet) {
        return livreRepository.findByAlphabet(alphabet);
    }

    @Transactional(readOnly = true)
    public List<String> findAllGenre() {
        return livreRepository.findAllGenre();
    }

    public List<Livre> chercher(String titre, String auteur) {

        return livreRepository.findAll((root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (titre != null) {
                predicates.add(cb.like(root.get("titre"),'%'+titre+'%'));
            }
            if (auteur != null) {
                predicates.add(cb.like(root.get("auteur"),'%'+auteur+'%'));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }

    @Transactional(readOnly = true)
    public Optional<Livre> findOne(Long id) {
        return livreRepository.findById(id);
    }


    public void delete(Long id) {
        livreRepository.deleteById(id);
    }
}
