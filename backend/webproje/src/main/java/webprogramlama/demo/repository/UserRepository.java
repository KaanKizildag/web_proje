/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import webprogramlama.demo.entity.users.User;

/**
 *
 * @author kaan
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> getByEmailAndPassword(String email, String password);

}
