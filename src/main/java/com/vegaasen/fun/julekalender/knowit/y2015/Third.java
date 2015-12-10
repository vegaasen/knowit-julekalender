package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * Programmererenes dag feires hvert år på den 256. dagen (eller 2^8. dagen om du vil) i året.
 * Hvor mange ganger fra og med år 1 til og med år 2015 har dette forekommet på en fredag om en
 * antar at 1. januar år 1 var en fredag i, samt at dagens skuddårsregler og kalendersystem har vært gjeldende i hele perioden?
 * <p>
 * Hint: Skuddår er forøvrig et år som er delelig på 4 og ikke 100 med mindre det er delelig på 400
 * <p>
 * OBS: Er blitt gjort oppmerksom på et avvik i oppgaven. Svaret som er lagt inn på oppgaven later til å anta at den første dagen i året er den "nulte" dagen i året.
 * <p>
 * Note: Jeah, this is not by far optimized, I know.
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 * @since 3.12.2015
 */
public class Third implements OJulMedDinGlede {

    private static final int Y_UNTIL = 2016;
    private static final int TARGET = 256;
    private static final LocalDate START_DATE = LocalDate.of(1, Month.JANUARY, 1);
    private static final DayOfWeek REQUIRED_DAY = START_DATE.getDayOfWeek();

    @Override
    public void hohoho() {
        new MeasuredInvocation(3) {
            @Override
            public void what() {
                LocalDate date = START_DATE;
                int year, occurred = 0;
                for (; ; ) {
                    if (date.plusDays(TARGET).getDayOfWeek() == REQUIRED_DAY) {
                        occurred++;
                    }
                    date = date.plusYears(1);
                    year = date.getYear();
                    if (year == Y_UNTIL) {
                        break;
                    }
                }
                System.out.println(String.format("{%s} days has the programmers day happened on a {%s} since 1.1.1 until {%s}", occurred, REQUIRED_DAY, Y_UNTIL));
            }
        }.execute();
    }

}
