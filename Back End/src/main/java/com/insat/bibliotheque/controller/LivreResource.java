package com.insat.bibliotheque.controller;

import com.insat.bibliotheque.domain.Livre;
import com.insat.bibliotheque.service.LivreService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class LivreResource {


    private static final String ENTITY_NAME = "livre";
    private final LivreService livreService;

    public LivreResource(LivreService livreService) {
        this.livreService = livreService;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/livres/genres")
    public List<String> getAllGenre() { return livreService.findAllGenre(); }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/livres")
    public List<Livre> getAllLivres() {
        return livreService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/livres/genre/{genre}")
    public List<Livre> getByGenre(@PathVariable String genre) {
        return livreService.findByGenre(genre);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/livres/alphabet/{alphabet}")
    public List<Livre> getByAlphabet(@PathVariable String alphabet) {
        return livreService.findByAlphabet(alphabet);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/livres/search")
    public List<Livre> chercher(@RequestParam(required = false) String titre,
                                       @RequestParam(required = false) String auteur
                                       ) {
        return livreService.chercher(titre, auteur);
    }




}
