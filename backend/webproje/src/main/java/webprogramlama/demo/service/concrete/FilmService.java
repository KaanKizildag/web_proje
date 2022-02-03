package webprogramlama.demo.service.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webprogramlama.demo.entity.Film;
import webprogramlama.demo.entity.dtos.FilmLanguageDTO;
import webprogramlama.demo.repository.FilmRepository;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public List<FilmLanguageDTO> findAllDtoile(){
        return filmRepository.findAllDtoile();
    }

    public Film findByQueryIle(String name){
        return filmRepository.findByQueryIle(name);
    }
}
