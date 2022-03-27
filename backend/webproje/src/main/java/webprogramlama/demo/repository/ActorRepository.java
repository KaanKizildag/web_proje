package webprogramlama.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import webprogramlama.demo.entity.Actor;
import webprogramlama.demo.entity.dtos.VeriTabaniNesnesiDTO;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    Long countByFirstNameIsIn(List<String> firstNameList);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    Long countByFirstName(String fistName);
//
//    @Query("Select dtoToString(:veri)")
//    String dtoToString(@Param("veri") String veri);

    @Query(value = "Select toDto()", nativeQuery = true)
    VeriTabaniNesnesiDTO toDto();

}
