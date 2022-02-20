package webprogramlama.demo.service.concrete;

import org.springframework.stereotype.Service;
import webprogramlama.demo.entity.Language;
import webprogramlama.demo.repository.LanguageRepository;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Language findById(Long id){
        return languageRepository.findById(id).get();
    }

}
