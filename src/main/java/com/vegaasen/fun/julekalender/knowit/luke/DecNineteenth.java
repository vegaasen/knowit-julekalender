package com.vegaasen.fun.julekalender.knowit.luke;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Unsolved - didn't get time! :-(
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class DecNineteenth {

    private static final String RUBBISH = "rubbish.text";

    public static void main(String... args) {
        doIt();
    }

    private static void doIt() {
        try {
            final StringBuilder builder = new StringBuilder();
            Files.readAllLines(Paths.get(ClassLoader.getSystemResource(RUBBISH).toURI())).parallelStream().forEach(builder::append);
            results(findPalindromes(builder.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> findPalindromes(final String what) {
        final int whatLength = what.length();
        final Map<String, Integer> palindromes = new HashMap<>();
        for (int i = 2; i <= whatLength; i++) {
            for (int j = 0; j <= whatLength; j++) {
                int k = i + j - 1;
                if (k >= whatLength) {
                    continue;
                }
                final String candidate = what.substring(j, i + j);
                if (candidate.equals(new StringBuilder(candidate).reverse().toString()) && !candidate.isEmpty()) {
                    palindromes.put(candidate, (palindromes.get(candidate) == null) ? 1 : palindromes.get(candidate) + 1);
                }
            }
        }
        return palindromes;
    }

    private static void results(final Map<String, Integer> results) {
        for (final Map.Entry<String, Integer> result : results.entrySet()) {
            System.out.println(result.getKey() + "=" + result.getValue());
        }
    }

}
