package webprogramlama.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "film")
@Getter
@Setter
public class Film {
    @Id
    @Column(name = "film_id")
    @GeneratedValue(generator = "film_film_id_seq")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "language_id")
    @ManyToOne
    private Language language;
}
