package com.vegaasen.fun.julekalender.knowit.y2014.luke;

import com.google.common.base.Stopwatch;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public final class DecFifteen {

    private static final int MAX = 9999, MIN = 1000;

    public static void main(String... args) {
        doIt();
    }

    private static void doIt() {
        final Set<Integer> candidates = new HashSet<>(MAX - MIN);
        final Stopwatch casio = Stopwatch.createStarted();
        for (int n = MIN; n < MAX; n++) {
            for (int x = 10; x <= 99; x++) {
                for (int y = 99; y >= 10; y--) {
                    if (x * y == n) {
                        if (isLegalCandidate(x, y)) {
                            candidates.add(n);
                        }
                    }
                }
            }
        }
        casio.stop();
        printResults(candidates, casio);
    }

    private static boolean isLegalCandidate(final int... nums) {
        boolean isDividable = false;
        for (final int i : nums) {
            if (i % 10 != 0) {
                return true;
            }
            if (i % 10 == 0) {
                isDividable = !isDividable;
            }
        }
        return isDividable;
    }

    private static void printResults(final Set<Integer> what, final Stopwatch watch) {
        what.parallelStream().forEach(System.out::println);
        System.out.println(String.format("There were {%s} candidates. The process took {%sms}",
                what.size(),
                watch.elapsed(TimeUnit.MILLISECONDS)));
    }

}
