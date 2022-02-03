package webprogramlama.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import webprogramlama.demo.entity.Actor;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    Long countByFirstNameIsIn(List<String> firstNameList);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    Long countByFirstName(String fistName);

}
