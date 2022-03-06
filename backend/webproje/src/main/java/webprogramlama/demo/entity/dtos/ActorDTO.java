package webprogramlama.demo.entity.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ActorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
    private AddressDTO address;
}
