package com.vegaasen.fun.julekalender.knowit.y2014.luke;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * _what_
 *
 * @author vegaasen
 */
public final class DecFifth {

    public static final int MAX_FACTOR = 987654321;

    public static void main(String... args) {
        doIt();
        doItWithGuava();
    }

    private static void doItWithGuava() {
        final Stopwatch casio = Stopwatch.createUnstarted();
        casio.start();
        long smallestLargestFactor = MAX_FACTOR;
        long num = 0;
        for (List<Integer> candidate : Collections2.permutations(Lists.asList(1, new Integer[]{2, 3, 4, 5, 6, 7, 8, 9}))) {
            num = convertIntegersToLong(candidate);
            long currentMax = findFactor(num);
            if (currentMax < smallestLargestFactor) {
                log("Guava: " + smallestLargestFactor);
                smallestLargestFactor = currentMax;
            }
        }
        casio.stop();
        logResult(casio, num, smallestLargestFactor);
    }

    private static void doIt() {
        final Stopwatch casio = Stopwatch.createUnstarted();
        casio.start();
        long num = 123456789;
        long smallestLargestFactor = num;
        for (long c = num; c <= MAX_FACTOR; c++) {
            if (haveDigits(c)) {
                long currentFactor = findFactor(c);
                if (currentFactor < smallestLargestFactor) {
                    log("Java: " + currentFactor);
                    smallestLargestFactor = currentFactor;
                    num = c;
                }
            }
        }
        casio.stop();
        logResult(casio, num, smallestLargestFactor);
    }

    private static long convertIntegersToLong(List<Integer> what) {
        String c = "";
        for (final Integer i : what) {
            c += Integer.toString(i);
        }
        return Long.parseLong(c);
    }

    private static long findFactor(long num) {
        long testNum = num;
        long testFactor = 2;
        while (testFactor <= Math.sqrt(testNum)) {
            if (testNum % testFactor == 0) {
                testNum = testNum / testFactor;
                testFactor = 1;
            }
            testFactor++;
        }
        return testNum;
    }

    private static boolean haveDigits(final Long candidate) {
        final String candidateString = Long.toString(candidate);
        for (int digit = 1; digit <= 9; digit++) {
            if (!candidateString.contains(Integer.toString(digit))) {
                return false;
            }
        }
        return true;
    }

    private static void logResult(Stopwatch stopwatch, long num, long smallestLargestFactor) {
        log(String.format("{%s} has the smallest factor {%s}. It took {%sms} {%ss]", num, smallestLargestFactor, stopwatch.elapsed(TimeUnit.MILLISECONDS), stopwatch.elapsed(TimeUnit.SECONDS)));
    }

    private static void log(final Object what) {
        System.out.println(what);
    }

}