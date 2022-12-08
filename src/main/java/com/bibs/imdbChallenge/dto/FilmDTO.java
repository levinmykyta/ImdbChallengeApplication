package com.bibs.imdbChallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmDTO {

    @JsonProperty("Title") // essa anotação permite buscar propriedades diferentes, nesse caso com inicial maíuscula por causa da base de dados
    private String title;
    @JsonProperty("Year")
    private String year;

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
