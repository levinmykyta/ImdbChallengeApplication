package com.bibs.imdbChallenge.converter;

import com.bibs.imdbChallenge.dto.FilmDTO;
import com.bibs.imdbChallenge.model.Film;
import org.springframework.stereotype.Component;

@Component // componente do spring, usado para injetar dependências
public class FilmConverter {

    public Film convertToFilm(FilmDTO filmDTO) {
        Film film = new Film();
        film.setTitle(filmDTO.getTitle());
        film.setYear(filmDTO.getYear());
        return film;
    }
}
