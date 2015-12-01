package com.vegaasen.fun.julekalender.knowit.y2014.luke;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public final class DecEight {

    private static final StringBuilder divisors = new StringBuilder();
    private static final int ITERATIONS = 10_000;
    private static final String DELIM = ",";

    public static void main(String... args) {
        doIt(ITERATIONS);
    }

    private static void doIt(final int numTimes) {
        for (int rounds = 1; rounds <= numTimes; rounds++) {
            int summerized = 0;
            for (int candidateNum = 1; candidateNum < rounds; candidateNum++) {
                if (rounds % candidateNum == 0) {
                    summerized += candidateNum;
                }
            }
            if (summerized == rounds) {
                appendDivisor(rounds);
            }
        }
        andPrintIt();
    }

    private static void appendDivisor(final int current) {
        divisors.append(current).append(DELIM);
    }

    private static void andPrintIt() {
        final String what = divisors.toString();
        System.out.println(
                what.lastIndexOf(DELIM) == what.length() - DELIM.length() ?
                        what.substring(0, what.length() - DELIM.length()) :
                        what);
    }

}
