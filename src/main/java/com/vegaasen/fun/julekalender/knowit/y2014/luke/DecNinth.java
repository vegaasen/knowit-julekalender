package com.vegaasen.fun.julekalender.knowit.y2014.luke;

import com.google.common.base.Stopwatch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Not the most fanciest solution out there, but its a solution :-P
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public final class DecNinth {

    private static final int START = 100, END = 999, MIN_ABOVE = 1_000, MAX_ABOVE = 9_999;
    private static final List<Integer> LEGALS = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    //not at all thread-safe! :-P
    private static final Set<Integer> ILLEGAL_NUMBERS = new HashSet<>(9);

    public static void main(String... args) {
        doIt();
    }

    private static void doIt() {
        final Set<Integer> matches = new HashSet<>();
        final Stopwatch casio = Stopwatch.createStarted();
        for (int n1 = START; n1 <= END; n1++) {
            for (int n2 = START; n2 <= END; n2++) {
                reinitializeSet();
                if (legalForAddition(n1, n2)) {
                    final int sum = n1 + n2;
                    if (sum <= MAX_ABOVE && sum >= MIN_ABOVE && verify(sum)) {
                        conditionallyAddNumber(n1, matches);
                        conditionallyAddNumber(n2, matches);
                    }
                }
            }
        }
        casio.stop();
        printResults(matches, casio);
    }

    private static void conditionallyAddNumber(final int candidate, final Set<Integer> where) {
        if (!where.contains(candidate)) {
            where.add(candidate);
        }
    }

    private static boolean legalForAddition(final int firstCandidate, final int secondCandidate) {
        boolean status = false;
        if (firstCandidate > 0) {
            status = verify(firstCandidate) && verify(secondCandidate);
        }
        return status;
    }

    private static boolean verify(int candidate) {
        boolean legal = false;
        for (char c : Integer.toString(candidate).toCharArray()) {
            legal = removeFoundLegal(Character.getNumericValue(c));
            if (!legal) {
                break;
            }
        }
        return legal;
    }

    private static boolean removeFoundLegal(final int candidate) {
        if (ILLEGAL_NUMBERS.contains(candidate)) {
            ILLEGAL_NUMBERS.remove(candidate);
            return true;
        }
        return false;
    }

    private static void reinitializeSet() {
        ILLEGAL_NUMBERS.clear();
        ILLEGAL_NUMBERS.addAll(LEGALS);
    }

    private static void printResults(final Set<Integer> what, final Stopwatch casio) {
        System.out.println(String.format("Found {%s} to be the lowest value", what.parallelStream().min(Integer::compare).get()));
        System.out.println(String.format("The operation took {%sms}", casio.elapsed(TimeUnit.MILLISECONDS)));
    }

}
