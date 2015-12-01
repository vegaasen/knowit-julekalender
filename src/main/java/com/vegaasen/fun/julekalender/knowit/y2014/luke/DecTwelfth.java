package com.vegaasen.fun.julekalender.knowit.y2014.luke;

import com.google.common.base.Stopwatch;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public final class DecTwelfth {

    public static void main(String... args) {
        doIt(2014);
    }

    private static void doIt(final int until) {
        final Set<Long> timesInZePast = new HashSet<>();
        final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("CET"));
        calendar.set(1337, Calendar.JANUARY, 1);
        final Stopwatch casio = Stopwatch.createStarted();
        while (calendar.get(Calendar.YEAR) <= until) {
            if (calendar.get(Calendar.DAY_OF_MONTH) == 13) {
                if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                    timesInZePast.add(calendar.getTimeInMillis());
                }
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        casio.stop();
        printResults(timesInZePast, true, casio);
    }

    private static void printResults(final Set<Long> what, final boolean printDates, final Stopwatch stopwatch) {
        if (printDates) {
            what.parallelStream().forEach(d -> System.out.println(new Date(d).toString()));
        }
        System.out.println(String.format("There were {%s} times in the past when Friday the 13th happend :-). The process itself took {%sms}", what.size(), stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }

}
