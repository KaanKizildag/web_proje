package webprogramlama.demo.service;

import org.springframework.stereotype.Service;
import webprogramlama.demo.entity.RaporBilgisi;
import webprogramlama.demo.repository.RaporBilgisiRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class RaporBilgisiService {
    private final RaporBilgisiRepository raporBilgisiRepository;

    public RaporBilgisiService(RaporBilgisiRepository raporBilgisiRepository) {
        this.raporBilgisiRepository = raporBilgisiRepository;
    }

    public RaporBilgisi findById(Long id) {
        return raporBilgisiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rapor bilgisi " + id + " ile bulunamadı"));
    }

}
