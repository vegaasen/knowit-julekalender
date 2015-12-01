package com.vegaasen.fun.julekalender.knowit.y2014.luke;

import com.google.common.base.Stopwatch;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Simple implementation using lambdas and conventional Java :-)
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class DecEighteenth {

    private static final String WORDS = "words.txt";
    private static final Map<String, Integer> ANAGRAMS = new HashMap<>();
    private static final int INITIAL_VALUE = 1;

    public static void main(String... args) {
        doIt();
    }

    private static void doIt() {
        try {
            final URI words = ClassLoader.getSystemResource(WORDS).toURI();
            doItWithLambda(words);
            doItWithConventionalJava(words);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Wops.");
        }
    }

    private static void doItWithLambda(URI words) throws IOException {
        final Stopwatch casio = Stopwatch.createStarted();
        Files
                .readAllLines(Paths.get(words))
                .stream()
                .map(String::toLowerCase)
                .map(String::toCharArray)
                .map(candidate -> {
                    Arrays.sort(candidate);
                    return new String(candidate);
                })
                .collect(
                        HashMap::new,
                        (HashMap<String, Integer> map, String candidate) -> map.merge(
                                candidate, 1, (what, counted) -> what + counted
                        ),
                        HashMap::putAll)
                .entrySet()
                .parallelStream().sorted((what, counted) -> counted.getValue().compareTo(what.getValue()))
                .findFirst()
                .ifPresent(result -> {
                    casio.stop();
                    System.out.println(String.format("Found {%s}. Using lambdas took {%sms}.", result, casio.elapsed(TimeUnit.MILLISECONDS)));
                });
    }

    private static void doItWithConventionalJava(URI words) throws IOException {
        final Stopwatch timex = Stopwatch.createStarted();
        Files.readAllLines(Paths.get(words)).stream().forEach(DecEighteenth::checkAndPotentiallyAddAnagram);
        final String mostSeen = filterResults();
        timex.stop();
        results(mostSeen, timex);
    }

    private static void checkAndPotentiallyAddAnagram(final String anagram) {
        final String sortedAnagram = sortString(anagram);
        if (ANAGRAMS.containsKey(sortedAnagram)) {
            ANAGRAMS.put(sortedAnagram, ANAGRAMS.get(sortedAnagram) + 1);
            return;
        }
        ANAGRAMS.put(sortedAnagram, INITIAL_VALUE);
    }

    private static String sortString(final String candidate) {
        final char[] a = candidate.toLowerCase().toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    private static String filterResults() {
        String mostSeen = "";
        int times = 0;
        for (final Map.Entry<String, Integer> anagram : ANAGRAMS.entrySet()) {
            if (anagram.getValue() > times) {
                times = anagram.getValue();
                mostSeen = anagram.getKey();
            }
        }
        ANAGRAMS.entrySet().parallelStream().filter(entry -> entry.getValue() >= 9).forEach(entry -> System.out.println(entry.getKey() + entry.getValue()));
        return mostSeen;
    }

    private static void results(final String mostSeen, final Stopwatch stopwatch) {
        System.out.println(String.format(
                        "The {%s} is the one which we've seen the most with {%s} occurrences out of {%s} candidates. Using conventional Java took {%sms}",
                        mostSeen,
                        ANAGRAMS.get(mostSeen),
                        ANAGRAMS.size(),
                        stopwatch.elapsed(TimeUnit.MILLISECONDS)
                )
        );
    }

}
