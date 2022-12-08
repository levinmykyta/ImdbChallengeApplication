package com.bibs.imdbChallenge.repository;

import com.bibs.imdbChallenge.model.Film;
import org.springframework.data.jpa.repository.JpaRepository; // nos proporciona métodos úteis para banco de dados
import org.springframework.stereotype.Repository;

@Repository // repository serve para manipular info (como pegar/botar no banco)
public interface FilmRepository extends JpaRepository<Film, Long> {
}
