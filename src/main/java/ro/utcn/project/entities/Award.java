package ro.utcn.project.entities;
import javax.persistence.*;

@Entity
@Table(name = "award")
public class Award {

    @Id
    @GeneratedValue
    private Integer award_id;

    @Column
    private String month;

    @Column
    private String award_type;

    @ManyToOne
    @JoinColumn(name = "household_profile_id")
    private HouseholdProfile householdProfile;

    public Award() {
    }

    public Integer getAward_id() {
        return award_id;
    }

    public void setAward_id(Integer award_id) {
        this.award_id = award_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAward_type() {
        return award_type;
    }

    public void setAward_type(String award_type) {
        this.award_type = award_type;
    }

    public HouseholdProfile getHouseholdProfile() {
        return householdProfile;
    }

    public void setHouseholdProfile(HouseholdProfile householdProfile) {
        this.householdProfile = householdProfile;
    }
}
