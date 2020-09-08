package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.utcn.project.entities.WasteProfile;

@Repository
public interface WasteProfileRepository extends JpaRepository<WasteProfile, Integer> {
}
