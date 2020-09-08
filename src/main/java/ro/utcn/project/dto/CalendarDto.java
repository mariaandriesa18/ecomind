package ro.utcn.project.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class CalendarDto {


    private String waste_collection_date;

    public String getWaste_collection_date() {
        return waste_collection_date;
    }

    public void setWaste_collection_date(String waste_collection_date) {
        this.waste_collection_date = waste_collection_date;
    }

    public LocalDate prettyDate() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(waste_collection_date, formatter);
    }
}
