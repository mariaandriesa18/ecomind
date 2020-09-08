package ro.utcn.project.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "household_profile")
public class HouseholdProfile {
    @Id
    @GeneratedValue
    private Integer household_profile_id;

    @Column
    private String household_name;

    @Column
    private String address;

    @Column
    private Integer nb_of_members;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> user;

    @OneToOne(mappedBy = "householdProfile")
    private WasteProfile wasteProfile;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Integer getHousehold_profile_id() {
        return household_profile_id;
    }

    public void setHousehold_profile_id(Integer household_profile_id) {
        this.household_profile_id = household_profile_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public WasteProfile getWasteProfile() {
        return wasteProfile;
    }

    public void setWasteProfile(WasteProfile wasteProfile) {
        this.wasteProfile = wasteProfile;
    }

    public String getHousehold_name() {
        return household_name;
    }

    public void setHousehold_name(String household_name) {
        this.household_name = household_name;
    }

    public Integer getNb_of_members() {
        return nb_of_members;
    }

    public void setNb_of_members(Integer nb_of_members) {
        this.nb_of_members = nb_of_members;
    }
}
