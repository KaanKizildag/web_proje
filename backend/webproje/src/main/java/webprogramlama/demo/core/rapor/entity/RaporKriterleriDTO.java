package webprogramlama.demo.core.rapor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class RaporKriterleriDTO implements Serializable {
    // burada tanımlanan field'lar jrxml dosyasındaki isimlerle aynı olmalıdır.
    private Long id;

    private String title;
    private String description;

    private String musteriAdi;
}
