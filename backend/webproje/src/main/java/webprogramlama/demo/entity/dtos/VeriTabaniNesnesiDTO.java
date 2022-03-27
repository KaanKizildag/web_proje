package webprogramlama.demo.entity.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "dto")
public class VeriTabaniNesnesiDTO {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
