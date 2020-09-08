package ro.utcn.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.utcn.project.entities.HouseholdProfile;

public interface HouseholdProfileRepository extends JpaRepository<HouseholdProfile,  Integer> {

    @Query("SELECT u FROM HouseholdProfile u WHERE u.household_name = :household_name")
    HouseholdProfile findHouseholdProfileByHousehold_name(@Param("household_name")String household_name);

}
