package com.bibs.imdbChallenge.service;

import com.bibs.imdbChallenge.client.FilmClientOmdbFeign;
import com.bibs.imdbChallenge.converter.FilmConverter;
import com.bibs.imdbChallenge.dto.FilmDTO;
import com.bibs.imdbChallenge.model.Film;
import com.bibs.imdbChallenge.repository.FilmRepository;
import com.bibs.imdbChallenge.vo.FilmOmdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    @Value("${imdb.apikey}") // pega o que ta no applications.properties
    private String apiKey;

    // não é necessário criar um novo objeto (com new) pq o spring já permite a injeção de tipos
    @Autowired // injeta dependências
    private FilmClientOmdbFeign filmClientFeign;

    @Autowired
    private FilmConverter filmConverter; // precisamos anotar @Component na classe do Converter para inicializarmos aqui

    @Autowired
    private FilmRepository filmRepository;

    // métodos
    public FilmOmdb getFilm(String theme) {
        return filmClientFeign.getFilm(theme, apiKey);
    }

    public Film save(FilmDTO filmDTO) {
        Film film = filmConverter.convertToFilm(filmDTO);
        return filmRepository.save(film);
    }

}
