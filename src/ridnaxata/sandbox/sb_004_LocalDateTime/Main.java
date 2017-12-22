package ridnaxata.sandbox.sb_004_LocalDateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS); // plus 1 week
        LocalDate nextSun = today.with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.SUNDAY)); // next sunday

    }

}
