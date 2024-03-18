package comfama.propuestacultural.repositories;

import comfama.propuestacultural.models.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
}
