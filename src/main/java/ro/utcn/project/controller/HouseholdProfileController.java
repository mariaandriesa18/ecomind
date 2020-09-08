package ro.utcn.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.utcn.project.dto.CalendarDto;
import ro.utcn.project.entities.Calendar;

import java.text.ParseException;
import java.time.LocalDate;


@Controller

@RequestMapping("/household_profile")
public class HouseholdProfileController {

    @GetMapping
    public String getHouseholdProfilePage(Model model){
        CalendarDto calendarDto = new CalendarDto();
        model.addAttribute("calendarObj", calendarDto);
        return "household_profile";
    }

    @PostMapping
    public String newWasteCollectionDate(CalendarDto calendarDto, Model model){
       try{
           LocalDate date = calendarDto.prettyDate();
       }catch(ParseException e){

        }

        return "household_profile";
    }

}
