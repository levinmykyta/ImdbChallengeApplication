package com.bibs.imdbChallenge.model;

import javax.persistence.*;

@Entity // representa entidade no banco (tabela)
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title") // para gerar nova coluna no banco de dados
    private String title;

    @Column(name="year")
    private String year;

    // GETTERS & SETTERS

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
