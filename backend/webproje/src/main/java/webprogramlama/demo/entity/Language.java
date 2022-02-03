package webprogramlama.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "language")
@Getter
@Setter
public class Language {

    @Id
    @Column(name = "language_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_update")
    Date last_update;
    @OneToMany(mappedBy = "language")
    private List<Film> filmList;
}
