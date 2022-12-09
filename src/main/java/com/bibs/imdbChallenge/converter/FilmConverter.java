package com.bibs.imdbChallenge.converter;

import com.bibs.imdbChallenge.dto.FilmDTO;
import com.bibs.imdbChallenge.model.Film;
import com.bibs.imdbChallenge.vo.FilmVO;
import org.springframework.stereotype.Component;

@Component // componente do spring, usado para injetar dependências
public class FilmConverter {

    public Film convertToFilm(FilmDTO filmDTO) {
        Film film = new Film();
        film.setTitle(filmDTO.getTitle());
        film.setYear(filmDTO.getYear());
        return film;
    }

    // faz a conversão do film para o filmVO (também poderia ser feito no FilmService)
    public FilmVO convertToFilmVO(Film film) {
        FilmVO filmVO = new FilmVO();
        filmVO.setId(film.getId());
        filmVO.setTitle(film.getTitle());
        filmVO.setYear(film.getYear());
        return filmVO;
    }
}
