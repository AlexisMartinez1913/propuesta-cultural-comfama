package comfama.propuestacultural.repositories;

import comfama.propuestacultural.models.AttachedDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachedDocumentRepository extends JpaRepository<AttachedDocument, Integer> {
}
