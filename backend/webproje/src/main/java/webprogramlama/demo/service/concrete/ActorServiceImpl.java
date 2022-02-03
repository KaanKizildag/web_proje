package webprogramlama.demo.service.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webprogramlama.demo.repository.ActorRepository;
import webprogramlama.demo.service.abstracts.ActorService;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Long countByFirstNameIsIn(List<String> firstNameList) {
        return actorRepository.countByFirstNameIsIn(firstNameList);
    }

    @Override
    public boolean existsByFirstNameAndLastName(String firstName, String lastName) {
        return actorRepository.existsByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Long countByFirstName(String fistName) {
        return actorRepository.countByFirstName(fistName);
    }
}
