package comfama.propuestacultural.repositories;

import comfama.propuestacultural.models.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProposalRepository extends JpaRepository <Proposal, Integer> {
}
