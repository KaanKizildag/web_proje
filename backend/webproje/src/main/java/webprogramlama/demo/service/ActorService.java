package webprogramlama.demo.service;

import org.modelmapper.ModelMapper;
import org.postgresql.util.PSQLException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import webprogramlama.demo.entity.Actor;
import webprogramlama.demo.entity.dtos.ActorDTO;
import webprogramlama.demo.entity.dtos.VeriTabaniNesnesiDTO;
import webprogramlama.demo.repository.ActorRepository;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final ModelMapper modelMapper;

    public ActorService(ActorRepository actorRepository, ModelMapper modelMapper) {
        this.actorRepository = actorRepository;
        this.modelMapper = modelMapper;
    }

    public void save(ActorDTO actorDTO) {
        Actor actor = modelMapper.map(actorDTO, Actor.class);
        actorRepository.save(actor);
    }

    public Long countByFirstNameIsIn(List<String> firstNameList) {
        return actorRepository.countByFirstNameIsIn(firstNameList);
    }

    public boolean existsByFirstNameAndLastName(String firstName, String lastName) {
        return actorRepository.existsByFirstNameAndLastName(firstName, lastName);
    }

    public Long countByFirstName(String fistName) {
        return actorRepository.countByFirstName(fistName);
    }

//    public String dtoToString(VeriTabaniNesnesiDTO veriTabaniNesnesiDTO){
//        return actorRepository.dtoToString(null);
//    }
    public VeriTabaniNesnesiDTO toDto(String name){
        return actorRepository.toDto();
    }
}
