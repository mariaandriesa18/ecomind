package ro.utcn.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import ro.utcn.project.dto.HouseholdProfileDto;
import ro.utcn.project.entities.HouseholdProfile;
import ro.utcn.project.entities.User;
import ro.utcn.project.mapper.HouseholdProfiledMapper;
import ro.utcn.project.repo.HouseholdProfileRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HouseholdProfileService {

    @Autowired
    private HouseholdProfileRepository householdProfileRepository;

    @Autowired
    private UserService userService;
    public List<HouseholdProfile> getAllHouseholdProfiles(){
        return householdProfileRepository.findAll();
    }

    @Transactional
    public void addHouseholdProfile(HouseholdProfileDto householdProfileDto, User user){
        HouseholdProfile householdProfile = HouseholdProfiledMapper.dtoToHouseholdProfile(householdProfileDto);
        householdProfileRepository.save(householdProfile);
        updateUserId(householdProfile, user);
    }

    @Transactional
    public void updateUserId(HouseholdProfile householdProfile, User user){
        HouseholdProfile householdProfile1 = householdProfileRepository.findHouseholdProfileByHousehold_name(householdProfile.getHousehold_name()) ;
        user.setHouseholdProfile(householdProfile1);
        userService.updateUser(user);
    }


}
