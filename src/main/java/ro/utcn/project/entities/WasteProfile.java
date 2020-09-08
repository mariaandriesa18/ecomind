package ro.utcn.project.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "waste_profile")
public class WasteProfile {

    @Id
    @GeneratedValue
    private Integer waste_profile_id;

    @Column
    private LocalDate waste_collection_day;
    @Column
    private Integer waste_amount;

    @Column
    private Integer recycled_amount;

    @OneToOne
    @JoinColumn(name = "household_profile_id")
    private HouseholdProfile householdProfile;


    public WasteProfile() {

    }

    public Integer getWaste_profile_id() {
        return waste_profile_id;
    }

    public void setWaste_profile_id(Integer waste_profile_id) {
        this.waste_profile_id = waste_profile_id;
    }

    public HouseholdProfile getHouseholdProfile() {
        return householdProfile;
    }

    public void setHouseholdProfile(HouseholdProfile householdProfile) {
        this.householdProfile = householdProfile;
    }


    public LocalDate getWaste_collection_day() {
        return waste_collection_day;
    }

    public void setWaste_collection_day(LocalDate waste_collection_day) {
        this.waste_collection_day = waste_collection_day;
    }

    public Integer getWaste_amount() {
        return waste_amount;
    }

    public void setWaste_amount(Integer waste_amount) {
        this.waste_amount = waste_amount;
    }

    public Integer getRecycled_amount() {
        return recycled_amount;
    }

    public void setRecycled_amount(Integer recycled_amount) {
        this.recycled_amount = recycled_amount;
    }
}
