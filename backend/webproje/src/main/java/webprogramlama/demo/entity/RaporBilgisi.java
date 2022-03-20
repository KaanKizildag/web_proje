package webprogramlama.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rapor_bilgisi")
@Getter
@Setter
public class RaporBilgisi {

    @Id
    @SequenceGenerator(name = "rapor_bilgisi_id_seq", sequenceName = "rapor_bilgisi_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rapor_bilgisi_id_seq")
    private Long id;
    @Column(name = "dosya_yolu")
    private String dosya_yolu;
}
