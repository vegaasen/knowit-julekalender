package com.vegaasen.fun.julekalender.knowit.y2014.luke;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class DecTwentySecond {

    private static final List<Integer> CANDIDATES = new ArrayList<>();
    private static final int ITERATIONS = 50;
    private static final String DELIM = ",";

    public static void main(final String... args) {
        Stopwatch casio = Stopwatch.createStarted();
        doIt();
        casio.stop();
        results(casio);
    }

    private static void doIt() {
        for (int i = 1; i <= ITERATIONS; i++) {
            if (findTheNumber(i) == 1) {
                CANDIDATES.add(i);
            }
        }
    }

    private static int findTheNumber(int num) {
        final Set<Integer> numbers = new HashSet<>();
        while (num != 1) {
            num = doSomeMagic(num);
            if (numbers.contains(num)) {
                break;
            }
            numbers.add(num);
        }
        return num;
    }

    private static int doSomeMagic(int num) {
        final String n = Integer.toString(num);
        int converted = 0;
        for (int i = 0; i < n.length(); i++) {
            int candidate = Integer.parseInt(n.substring(i, i + 1));
            converted += candidate * candidate;
        }
        return converted;
    }

    private static void results(Stopwatch watch) {
        CANDIDATES.stream().forEach(c -> System.out.print(c + DELIM));
        System.out.print(String.format("out of {%s} iterations, {%s} had this weird logic. It took {%sms}.", ITERATIONS, CANDIDATES.size(), watch.elapsed(TimeUnit.MILLISECONDS)));
    }

}
