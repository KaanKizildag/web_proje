package webprogramlama.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webprogramlama.demo.entity.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
