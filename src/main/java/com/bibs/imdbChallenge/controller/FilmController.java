package com.bibs.imdbChallenge.controller;


import com.bibs.imdbChallenge.service.FilmService;
import com.bibs.imdbChallenge.vo.FilmOmdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controla serviços e end points
@RestController
@RequestMapping("/film") // controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    // método para fazer a chamada para o Service
    @GetMapping("/omdb/{theme}") //end point
    public ResponseEntity<FilmOmdb> getFilm(@PathVariable String theme) {
        try {
            FilmOmdb filmeOMDB = filmService.getFilm(theme);
            return ResponseEntity.status(HttpStatus.OK).body(filmeOMDB);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
