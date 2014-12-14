package com.vegaasen.fun.julekalender.knowit.luke;

import com.google.common.base.Stopwatch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Remove the set for more performance - if that's what you're after
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public final class DecFourteenth {

    private static final Map<Integer, Integer> ROTATABLE_NUMBERS = new HashMap<>(5);
    private static final int ITERATIONS = 100_000, UNDETECTED = 0;

    static {
        ROTATABLE_NUMBERS.put(0, 0);
        ROTATABLE_NUMBERS.put(1, 1);
        ROTATABLE_NUMBERS.put(6, 9);
        ROTATABLE_NUMBERS.put(8, 8);
        ROTATABLE_NUMBERS.put(9, 6);
    }

    public static void main(String... args) {
        doIt();
    }

    private static void doIt() {
        final Stopwatch casio = Stopwatch.createStarted();
        final Set<Integer> candidates = new HashSet<>();
        int detected = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            if (isRotatable(i)) {
                candidates.add(i);
                detected++;
            }
        }
        casio.stop();
        printResults(detected, candidates, casio);
    }

    private static boolean isRotatable(final int candidate) {
        final String stringified = Integer.toString(candidate);
        StringBuilder builder = new StringBuilder();
        for (final char c : stringified.toCharArray()) {
            builder.append(detectAndRotate(c));
        }
        return (builder.reverse().toString().equals(stringified));
    }

    private static int detectAndRotate(final char candidate) {
        for (final Map.Entry<Integer, Integer> things : ROTATABLE_NUMBERS.entrySet()) {
            if (Character.getNumericValue(candidate) == things.getKey()) {
                return things.getValue();
            }
        }
        return UNDETECTED;
    }

    private static void printResults(final int numOf, final Set<Integer> candidates, final Stopwatch stopwatch) {
        candidates.forEach(System.out::println);
        System.out.println(
                String.format("There were {%s} detected candidates. It took {%sms}.",
                        numOf,
                        stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }

}
