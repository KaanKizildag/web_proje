/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.service.concrete;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webprogramlama.demo.entity.users.User;
import webprogramlama.demo.repository.UserRepository;
import webprogramlama.demo.service.abstracts.UserService;

/**
 *
 * @author kaan
 */
@Service
public class UserServiceImpl implements UserService {
    
    private UserRepository repository;
    
    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
    
    @Override
    public boolean getByEmailAndPassword(String email, String password) {
        return !repository.getByEmailAndPassword(email, password).isEmpty();
    }
    
    @Override
    public void add(User user) {
        repository.save(user);
    }
    
    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }


}
