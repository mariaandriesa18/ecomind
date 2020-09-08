package ro.utcn.project.dto;

public class HouseholdProfileDto {

    private String household_name;
    private String nb_of_members;
    private String address;

    public HouseholdProfileDto() {
    }

    public String getHousehold_name() {
        return household_name;
    }

    public void setHousehold_name(String household_name) {
        this.household_name = household_name;
    }

    public String getNb_of_members() {
        return nb_of_members;
    }

    public void setNb_of_members(String nb_of_members) {
        this.nb_of_members = nb_of_members;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
