package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.project.entities.Award;

public interface AwardRepository extends JpaRepository<Award, Integer> {
}
