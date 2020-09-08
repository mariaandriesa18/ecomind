package ro.utcn.project.mapper;

import org.springframework.stereotype.Component;
import ro.utcn.project.dto.CalendarDto;
import ro.utcn.project.entities.Calendar;

import java.text.ParseException;

@Component
public class CalendarMapper {
    public static Calendar dtoToCalendar(CalendarDto calendarDto) throws ParseException {
            Calendar calendar = new Calendar();
            calendar.setWaste_collection_date(calendarDto.prettyDate());
            return calendar;
    }
}
