package com.bibs.imdbChallenge.controller;


import com.bibs.imdbChallenge.converter.FilmConverter;
import com.bibs.imdbChallenge.dto.FilmDTO;
import com.bibs.imdbChallenge.service.FilmService;
import com.bibs.imdbChallenge.vo.FilmOmdb;
import com.bibs.imdbChallenge.vo.FilmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

// controla serviços e end points
@RestController
@RequestMapping("/film") // controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmConverter filmConverter; // para usar no método abaixo

    // método para fazer a chamada para o Service
    @GetMapping("/omdb/{theme}") //end point
    public ResponseEntity<FilmOmdb> getFilm(@PathVariable String theme) {
        try {
            FilmOmdb filmOMDB = filmService.getFilm(theme);
            return ResponseEntity.status(HttpStatus.OK).body(filmOMDB);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // usamos o filmDTO para pegar infos do client. Para devolver (depois de salvo) usamos o filmVO (view object)
    @PostMapping // post is used to save info
    public ResponseEntity<FilmVO> saveFilm(@RequestBody FilmDTO filmDTO) {
        try {
            FilmVO filmVO = filmConverter.convertToFilmVO(filmService.save(filmDTO));
            addHateoas(filmVO);
            return ResponseEntity.status(HttpStatus.CREATED).body(filmVO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmVO> getById(@PathVariable("id") Long id) {
        try {
            FilmVO filmVO = filmConverter.convertToFilmVO(filmService.getById(id));
            return ResponseEntity.ok(filmVO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void addHateoas(FilmVO filmVO) {
        filmVO.add(linkTo(methodOn(FilmController.class).getById(filmVO.getId()))
                .withSelfRel());
    }

}
