/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webprogramlama.demo.entity.users.BookKeeper;
import webprogramlama.demo.entity.users.Customer;
import webprogramlama.demo.entity.users.User;
import webprogramlama.demo.service.abstracts.UserService;

/**
 *
 * @author kaan
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return service.getAll();
    }


    @PostMapping("/addBookKeeper")
    public void add(@RequestBody BookKeeper bookKeeper) {
        service.add(bookKeeper);
    }

    @PostMapping("/addCustomer")
    public void add(@RequestBody Customer customer) {
        service.add(customer);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam int id) {
        service.delete(id);
    }

    @GetMapping("/getByEmailAndPassword")
    public boolean getByEmailAndPassword(
            @RequestParam String email, @RequestParam String password) {
        return service.getByEmailAndPassword(email, password);
    }

}
