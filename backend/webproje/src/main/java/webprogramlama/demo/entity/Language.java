package webprogramlama.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "language")
@Getter
@Setter
@NoArgsConstructor
public class Language{

    @Id
    @Column(name = "language_id")
    @GeneratedValue(generator = "language_language_id_seq")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_update")
    Date last_update;
    @OneToMany(mappedBy = "language")
    private List<Film> filmList;

}
