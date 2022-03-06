package webprogramlama.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actor")
@Getter
@Setter
public class Actor {

    @Id
    @Column(name = "actor_id")
    @SequenceGenerator(
            name = "actor_actor_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_actor_id_seq")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToOne
    @JoinColumn(name = "addresId")
    private Address address;
}
