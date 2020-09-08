package ro.utcn.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.project.entities.HouseholdProfile;
import ro.utcn.project.service.HouseholdProfileService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired
    private HouseholdProfileService householdProfileService;

    @GetMapping
    public ModelAndView getAllHouseholds(){
        ModelAndView modelAndView = new ModelAndView();
        List<HouseholdProfile> householdProfileList = householdProfileService.getAllHouseholdProfiles();
        modelAndView.addObject("householdProfileList", householdProfileList);
        modelAndView.addObject("householdProfile", new HouseholdProfile());
        modelAndView.setViewName("admin");
        return modelAndView;
    }


}
