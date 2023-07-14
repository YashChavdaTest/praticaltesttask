package practical.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

public class DateHelper {
    public static LocalDate firstOfMonth(Year year, Month month, DayOfWeek dayOfWeek){
        LocalDate date = LocalDate.of(year.getValue(), month, 1);
        LocalDate firstDay = date.with(TemporalAdjusters.firstInMonth(dayOfWeek));
        return firstDay;
    }
    public static LocalDate thirdOfMonth(Year year, Month month,DayOfWeek dayOfWeek){
        LocalDate date = LocalDate.of(year.getValue(), month, 1);
        LocalDate firstDay = date.with(TemporalAdjusters.firstInMonth(dayOfWeek));
        LocalDate thirdDay = firstDay.plusWeeks(2);
        return thirdDay;
    }
}
