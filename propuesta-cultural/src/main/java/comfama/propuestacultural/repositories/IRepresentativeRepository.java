package comfama.propuestacultural.repositories;

import comfama.propuestacultural.models.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepresentativeRepository extends JpaRepository<Representative, Integer> {
}
