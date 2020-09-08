package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.project.entities.RecyclingInformation;

public interface RecyclingInformationRepository extends JpaRepository<RecyclingInformation, Integer> {
    
}
