package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.project.entities.CommunityStatistics;

public interface CommunityStatisticsRepository extends JpaRepository<CommunityStatistics, Integer> {
}
