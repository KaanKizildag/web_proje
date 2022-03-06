package webprogramlama.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webprogramlama.demo.entity.Actor;
import webprogramlama.demo.entity.dtos.ActorDTO;
import webprogramlama.demo.service.concrete.ActorService;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/countByFirstNameIsIn")
    public Long countByFirstNameIsIn(@RequestBody List<String> firstNameList) {
        return actorService.countByFirstNameIsIn(firstNameList);
    }

    @PostMapping("/save")
    public void save(@RequestBody ActorDTO actorDTO){
        actorService.save(actorDTO);
    }

    @GetMapping("/countByFirstName")
    public Long countByFirstName(@RequestParam String firstName) {
        return actorService.countByFirstName(firstName);
    }

}
