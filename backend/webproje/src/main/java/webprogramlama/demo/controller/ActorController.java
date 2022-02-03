package webprogramlama.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webprogramlama.demo.service.abstracts.ActorService;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/countByFirstNameIsIn")
    public Long countByFirstNameIsIn(@RequestBody List<String> firstNameList){
        return actorService.countByFirstNameIsIn(firstNameList);
    }

    @GetMapping("/countByFirstName")
    public Long countByFirstName(@RequestParam String firstName){
        return actorService.countByFirstName(firstName);
    }

}
