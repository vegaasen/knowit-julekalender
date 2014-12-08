package com.vegaasen.fun.julekalender.knowit.luke;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public final class DecSixth {

    private static final int[][] MATRIX_9_9 = new int[10][10];
    private static final int[][] MATRIX_8K_8K = new int[8001][8001];

    public static void main(String... args) {
        logResult(doIt(MATRIX_9_9));
        logResult(doIt(MATRIX_8K_8K));
    }

    private static Set<Integer> doIt(final int[][] what) {
        if (what == null || what.length == 0) {
            return Collections.emptySet();
        }
        Set<Integer> matchedNumbers = new HashSet<>();
        for (int num = 0; num < what.length; num++) {
            if (num > 0) {
                for (int j = 0; j < what[num].length; j++) {
                    final int prime = num * j;
                    if (!matchedNumbers.contains(prime) && 0 != prime) {
                        matchedNumbers.add(prime);
                    }
                    what[num][j] = prime;
                }
            }
        }
        return matchedNumbers;
    }

    private static void logResult(final Set<?> what) {
        System.out.println(String.format("There is {%s} unique entries in the set", what.size()));
    }

}
