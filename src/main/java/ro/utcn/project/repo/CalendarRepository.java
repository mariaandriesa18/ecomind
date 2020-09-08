package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.project.entities.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {
}
