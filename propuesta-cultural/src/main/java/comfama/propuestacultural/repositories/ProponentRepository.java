package comfama.propuestacultural.repositories;

import comfama.propuestacultural.models.Proponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProponentRepository extends JpaRepository<Proponent,  UUID> {
}