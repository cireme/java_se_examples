package object_manipulation.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class DateService {

    public DateService() throws ParseException {
        this.run();
    }

    private void run() throws ParseException {
        printLine();
        dateUse();
        printLine();
        localDateTimeUse();
    }

    public void dateUse() throws ParseException {
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // print a date with the given format
        System.out.println(dateFormat.format(now));

        // create a date using the given format
        Date someDate = dateFormat.parse("01/01/2000");
        System.out.println(someDate);
    }

    public void localDateTimeUse() {
        // first day & month are 1 (not 0)
        LocalDate someDate = LocalDate.of(2000, 1, 1);
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);

        date = date.minusDays(1);
        time = time.minusHours(2).plusMinutes(35);
        dateTime = dateTime.minusMonths(1).plusDays(2);

        if(someDate.isBefore(date)) {
            System.out.println("2000 was a long time ago oO");
        }
    }

    private void printLine() {
        System.out.println("-----------------------------");
    }
}
