package webprogramlama.demo.service.abstracts;

import java.util.List;

public interface ActorService {

    Long countByFirstNameIsIn(List<String> firstNameList);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    Long countByFirstName(String fistName);

}
