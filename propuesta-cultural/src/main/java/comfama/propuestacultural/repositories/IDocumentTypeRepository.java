package comfama.propuestacultural.repositories;

import comfama.propuestacultural.models.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
}
