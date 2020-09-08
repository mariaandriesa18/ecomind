package ro.utcn.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.project.dto.CalendarDto;
import ro.utcn.project.entities.Calendar;
import ro.utcn.project.mapper.CalendarMapper;
import ro.utcn.project.repo.CalendarRepository;


import java.text.ParseException;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;

    public void addNewCollectionDate(CalendarDto calendarDto, String username){

        Calendar calendar = new Calendar();
        try{
            calendar = CalendarMapper.dtoToCalendar(calendarDto);
        }catch ( ParseException e){

        }
        calendar.setRequestor("user");
        // calendar.setHouseholdProfile();
    }
}
