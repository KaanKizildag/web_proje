package webprogramlama.demo.actor;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import webprogramlama.demo.service.concrete.ActorServiceImpl;

import static org.junit.Assert.*;

public class ActorServiceTest {

    @Autowired
    private ActorServiceImpl actorService;

    private Long sonuc;

    @When("{string} adindaki aktorerin sayisi getirilmelidir")
    public void adindakiAktorerinSayisiGetirilmelidir(String aktorAdi) {
        sonuc = actorService.countByFirstName(aktorAdi);
    }

    @Then("{string} tane aktor bulunmalidir.")
    public void taneAktorBulunmalidir(String aktorSayisi) {
        assertEquals(Long.valueOf(aktorSayisi), sonuc);
    }

}
