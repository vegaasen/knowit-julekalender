package com.vegaasen.fun.julekalender.knowit.luke;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class DecTwentyThird {

    private static final int MAX = 1000;

    public static void main(final String... args) {
        doIt();
    }

    private static void doIt() {
        int hits = 0;
        for (int point = 1; point <= MAX; point++) {
            if (checkForWeirdness(point)) {
                hits++;
            }
        }
        results(hits);
    }

    private static boolean checkForWeirdness(final int num) {
        final String numAsString = Integer.toString(num);
        for (int i = 0; i <= numAsString.length(); i++) {
            int sum =
                    i == numAsString.length() ?
                            num :
                            (Integer.parseInt(numAsString.substring(i, numAsString.length())) + Integer.parseInt(numAsString.substring(i + 1, numAsString.length())));
            if (checkNumber(num, sum)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkNumber(final int num, int sum) {
        sum ^= sum;
        System.out.println(sum);
        return sum == num;
    }

    private static void results(final int num) {
        System.out.println(String.format("There were {%s} hits", num));
    }

}
