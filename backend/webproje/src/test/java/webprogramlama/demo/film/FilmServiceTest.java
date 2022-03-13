package webprogramlama.demo.film;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import webprogramlama.demo.entity.Film;
import webprogramlama.demo.service.FilmService;
import webprogramlama.demo.service.LanguageService;

public class FilmServiceTest {

    @Autowired
    private FilmService filmService;

    @Autowired
    private LanguageService languageService;

    private Film film;

    @When("{string} bir film eklenmelidir")
    public void birFilmEklenmelidir(String filmBasligi) {
        film = new Film();
        film.setTitle(filmBasligi);
        film.setDescription("aciklama");
        film.setLanguage(languageService.findById(1L));
        filmService.save(film);
    }

    @Given("{string} adinda bir film olmalidir")
    public void adindaBirFilmOlmalidir(String arg0) {
        if (filmService.findByTitle(arg0) == null) {
            film = new Film();
            film.setTitle(arg0);
            film.setDescription("aciklama");
            film.setLanguage(languageService.findById(1L));
            filmService.save(film);
        }
    }

    @When("{string} film silinmelidir")
    public void filmSilinmelidir(String filmAdi) {
        film = filmService.findByTitle(filmAdi);
        filmService.delete(film);
    }


    @When("{string}, film adi {string} ile guncellenmelidir")
    public void filmAdiIleGuncellenmelidir(String eskiFilmAdi, String yeniFilmAdi) {
        film = filmService.findByTitle(eskiFilmAdi);
        film.setTitle(yeniFilmAdi);
        filmService.save(film);
    }

    @Then("{string} ile film bulunmalidir")
    public void ileFilmBulunmalidir(String filmBasligi) {
        Assert.assertNotEquals(filmService.findByTitle(filmBasligi), null);
    }

    @Given("film tablosu bos olmamalidir")
    public void filmTablosuBosOlmamalidir() {
        Assert.assertNotEquals(filmService.findAll(), null);
    }

    @Then("filmler listelenebilmelidir")
    public void filmlerListelenebilmelidir() {
        Assert.assertNotEquals(filmService.findAll(), null);
    }

    @Then("{string} ile film eklenmis olmalidir")
    public void ileFilmEklenmisOlmalidir(String filmBasligi) {
        Assert.assertNotEquals(filmService.findByTitle(filmBasligi), null);
    }

    @Then("{string} film bulunamamalidir")
    public void filmBulunamamalidir(String arg0) {
        Assert.assertEquals(filmService.findByTitle(arg0), null);
    }

}
