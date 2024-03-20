package comfama.propuestacultural.repositories;

import comfama.propuestacultural.models.AttachedDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachedDocumentRepository extends JpaRepository<AttachedDocument, Integer> {
}
