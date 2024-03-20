package comfama.propuestacultural.repositories;

import comfama.propuestacultural.models.ProposerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProposerTypeRepository extends JpaRepository<ProposerType, Integer> {

}
