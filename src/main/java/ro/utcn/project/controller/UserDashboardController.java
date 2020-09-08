package ro.utcn.project.controller;

import org.slf4j.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.utcn.project.constants.EndpointsRoutes;
import ro.utcn.project.constants.RedirectRoutes;
import ro.utcn.project.dto.HouseholdProfileDto;
import ro.utcn.project.dto.UserDto;
import ro.utcn.project.entities.HouseholdProfile;
import ro.utcn.project.entities.User;
import ro.utcn.project.mapper.UserMapper;
import ro.utcn.project.service.HouseholdProfileService;
import ro.utcn.project.service.UserService;

/**
 * User endpoints controller
 * You can add this path to route constants too.
 * Just be careful to separate ROOT paths from specific endpoints routes.
 *
 * Controllers can also provide security  at each endpoint (method/request mapping).
 * (Please check the annotations @PreAuthorize).
 */
@Controller
public class UserDashboardController {
    private static final Logger log = LoggerFactory.getLogger(UserDashboardController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private HouseholdProfileService householdProfileService;



    @GetMapping(EndpointsRoutes.USER_WITHOUT_HOUSEHOLD)
    public String getUserWithHouseholdPage(Model model){
        model.addAttribute("name", userService.getSessionUserUsername());
        HouseholdProfileDto householdProfileDto = new HouseholdProfileDto();
        model.addAttribute("householdObj", householdProfileDto);
        return EndpointsRoutes.USER_WITHOUT_HOUSEHOLD;
    }

    @PostMapping(EndpointsRoutes.USER_WITHOUT_HOUSEHOLD)
    public String  createHouseholdProfile(HouseholdProfileDto householdProfileDto, Model model, BindingResult bindingResult){
       if(householdProfileDto.getHousehold_name().equals("")){
           bindingResult.rejectValue("household_name", "Please insert household name.");
       }
       if(householdProfileDto.getAddress().equals("")){
           bindingResult.rejectValue("address", "Please insert address.");
       }
       if(householdProfileDto.getNb_of_members().equals("")){
           bindingResult.rejectValue("nb_of_members", "Please insert number of members in you household.");
       }
        User user =  userService.findByUserName(userService.getSessionUserUsername());

       if(bindingResult.hasErrors()){
           return EndpointsRoutes.USER_WITHOUT_HOUSEHOLD;
       }else{
           householdProfileService.addHouseholdProfile(householdProfileDto, user);
           model.addAttribute("householdObj", new HouseholdProfile());
           return RedirectRoutes.USER_WITH_REDIRECT;
       }

    }

    @GetMapping(EndpointsRoutes.USER_WITH_HOUSEHOLD )
    public String  getUserWithoutHouseholdProfilePage(Model model){
        model.addAttribute("name", userService.getSessionUserUsername());
        return EndpointsRoutes.USER_WITH_HOUSEHOLD;
    }

    @PostMapping(EndpointsRoutes.USER_WITH_HOUSEHOLD + "/delete")
    public String deleteUserAccount(Model model){
        userService.deleteUser(userService.getSessionUserUsername());
        return RedirectRoutes.LOGIN_REDIRECT;
    }

    @PostMapping(EndpointsRoutes.USER_WITH_HOUSEHOLD +"/edit")
    public String editUserAccount(UserDto userDto, Model model){
        String username = userService.getSessionUserUsername();
        userService.updateUserbyUsername(userDto, username);
        return  RedirectRoutes.LOGIN_REDIRECT;
    }
    @GetMapping(EndpointsRoutes.USER_WITH_HOUSEHOLD + "/edit")
    public String getEditPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userEdit", userDto);
        return "/edit";
    }
}
