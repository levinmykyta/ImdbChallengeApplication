package com.bibs.imdbChallenge.vo;

import org.springframework.hateoas.RepresentationModel;

// usamos essa classe para devolver as informações depois que pegamos ela do cliente (pelo FilmDTO) e salvamos
public class FilmVO extends RepresentationModel<FilmVO> {

    private Long id;
    private String title;
    private String year;

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
