package ro.utcn.project.mapper;

import ro.utcn.project.dto.HouseholdProfileDto;
import ro.utcn.project.entities.HouseholdProfile;

public class HouseholdProfiledMapper {

    public static HouseholdProfile dtoToHouseholdProfile(HouseholdProfileDto householdProfileDto){
        HouseholdProfile householdProfile = new HouseholdProfile();
        householdProfile.setHousehold_name(householdProfileDto.getHousehold_name());
        householdProfile.setAddress(householdProfileDto.getAddress());
        householdProfile.setNb_of_members(Integer.parseInt(householdProfileDto.getNb_of_members()));
        return householdProfile;
    }
}
