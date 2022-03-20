package webprogramlama.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webprogramlama.demo.entity.RaporBilgisi;

@Repository
public interface RaporBilgisiRepository extends JpaRepository<RaporBilgisi, Long> {
}
