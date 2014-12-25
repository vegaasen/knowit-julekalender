package com.vegaasen.fun.julekalender.knowit.luke;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class DecTwentieth {

    private static int[][] TRASKE_NETT = new int[][]{};

    public static void main(String... args) {
        initialize();
        doIt();
    }

    private static void initialize() {
        
    }

    private static void doIt() {
        for (int x = 0; x < TRASKE_NETT.length; x++) {
            for (int y = 0; y < TRASKE_NETT[x].length; y++) {
                System.out.println(x);
            }
        }
    }

}
