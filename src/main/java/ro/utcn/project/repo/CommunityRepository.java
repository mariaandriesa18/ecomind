package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.project.entities.Community;

public interface CommunityRepository extends JpaRepository<Community, Integer> {
}
