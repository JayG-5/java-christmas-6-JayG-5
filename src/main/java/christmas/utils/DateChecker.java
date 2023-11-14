package christmas.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateChecker {

    private static DayOfWeek getDayofWeek(int year, int month, int day){
        LocalDate date = LocalDate.of(year,month,day);
        return date.getDayOfWeek();
    }
    public static boolean isWeekend(int year, int month, int day) {
        final DayOfWeek dayOfWeek = getDayofWeek(year, month, day);
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}
