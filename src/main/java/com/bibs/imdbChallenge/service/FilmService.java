package com.bibs.imdbChallenge.service;

import com.bibs.imdbChallenge.client.FilmClientOmdbFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    // não é necessário criar um novo objeto (com new) pq o spring já permite a injeção de tipos
    @Autowired // injeta dependências
    private FilmClientOmdbFeign clientOmdbFeign;
}
