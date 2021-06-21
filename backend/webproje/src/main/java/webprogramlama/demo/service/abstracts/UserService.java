/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.service.abstracts;

import java.util.List;
import webprogramlama.demo.entity.users.User;

/**
 *
 * @author kaan
 */
public interface UserService {

    List<User> getAll();

    boolean getByEmailAndPassword(String email, String password);

    void add(User user);

    void delete(int id);
}
