package one.digin.tubainaApi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import one.digin.tubainaApi.entity.Tubaina;

public interface TubainaRepository extends JpaRepository<Tubaina, Long> {

    Optional<Tubaina> findByName(String name);
}
