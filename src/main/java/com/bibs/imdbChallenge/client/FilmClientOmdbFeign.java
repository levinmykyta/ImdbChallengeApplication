package com.bibs.imdbChallenge.client;

import com.bibs.imdbChallenge.vo.FilmOmdb;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="omdbFilms", url="https://www.omdbapi.com/")
public interface FilmClientOmdbFeign {

    // requisição do tipo GET para obter info
    @RequestMapping(method = RequestMethod.GET)
    FilmOmdb getFilm(@RequestParam("t") String theme, @RequestParam("apiKey") String key);
}