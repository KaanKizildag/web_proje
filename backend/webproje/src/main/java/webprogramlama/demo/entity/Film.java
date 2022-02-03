package webprogramlama.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "film")
@Getter
@Setter
public class Film {
    @Id
    @Column(name = "film_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne
    private Language language;
}
