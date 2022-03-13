package webprogramlama.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webprogramlama.demo.entity.Film;
import webprogramlama.demo.entity.dtos.FilmLanguageDTO;
import webprogramlama.demo.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/findAll")
    public List<FilmLanguageDTO> findAllDtoile() {
        return filmService.findAllDtoile();
    }

    @GetMapping("/findAllQuery")
    public Film findAllQueryile(@RequestParam String name) {
        return filmService.findByQueryIle(name);
    }

}
