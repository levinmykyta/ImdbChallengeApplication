package com.bibs.imdbChallenge.service;

import com.bibs.imdbChallenge.client.FilmClientOmdbFeign;
import com.bibs.imdbChallenge.vo.FilmOmdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    @Value("${imdb.apiKey}") // pega o que ta no applications.properties
    private String apiKey;

    // não é necessário criar um novo objeto (com new) pq o spring já permite a injeção de tipos
    @Autowired // injeta dependências
    private FilmClientOmdbFeign filmClientFeign;

    // método
    public FilmOmdb getFilm(String theme) {
        return filmClientFeign.getFilm(theme, apiKey);
    }
}
