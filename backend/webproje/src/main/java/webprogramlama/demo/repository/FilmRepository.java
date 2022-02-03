package webprogramlama.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import webprogramlama.demo.entity.Film;
import webprogramlama.demo.entity.dtos.FilmLanguageDTO;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("Select new webprogramlama.demo.entity.dtos.FilmLanguageDTO(f.title, l.name) " +
            "From Language l Inner Join l.filmList f")
    List<FilmLanguageDTO> findAllDtoile();

    @Query("From Film f, Language l where f.title = :name and l.id = f.language.id")
    Film findByQueryIle(String name);

}
