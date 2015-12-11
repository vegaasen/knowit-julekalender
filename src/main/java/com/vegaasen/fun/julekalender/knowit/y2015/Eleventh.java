package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Eleventh implements OJulMedDinGlede {

    private static final List<String> WHAT;
    private static final String PREFIX = "0b";
    private static final Map<Character, Integer> ROMANZ = new HashMap<>();

    static {
        List<String> whatz = new ArrayList<>();
        try {
            whatz = Files.readAllLines(PathPrettifier.INSTANCE.getFormattedPath("/2015/11_p1eVAM5H.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        WHAT = whatz;
        ROMANZ.put('I', 1);
        ROMANZ.put('V', 5);
        ROMANZ.put('X', 10);
        ROMANZ.put('L', 50);
        ROMANZ.put('C', 100);
        ROMANZ.put('D', 500);
        ROMANZ.put('M', 1000);
    }

    @Override
    public void hohoho() {
        new MeasuredInvocation(11) {
            @Override
            public void what() {
                List<Numbah> translated = WHAT.parallelStream().map(Eleventh::translate).sorted().collect(Collectors.toList());
                System.out.println(String.format("Of {%s} items, the media is located at {%s}. Object: {%s}", translated.size(), translated.size() / 2, translated.get(translated.size() / 2)));
            }
        }.execute();
    }

    private static Numbah translate(String candidate) {
        if (candidate.matches("[0-9]+")) {
            return Numbah.create(candidate, Integer.parseInt(candidate));
        } else if (candidate.startsWith(PREFIX)) {
            return Numbah.create(candidate, Integer.parseInt(candidate.substring(PREFIX.length(), candidate.length()), 2));
        } else if (candidate.matches("[IVXLCDM]+")) {
            return Numbah.create(candidate, translateRomanNumbah(candidate));
        }
        throw new IllegalArgumentException("wups :)");
    }

    public static int translateRomanNumbah(String romanCandidate) {
        int roman = 0, prev = 0;
        for (int i = romanCandidate.length() - 1; i >= 0; i--) {
            int candidate = ROMANZ.get(romanCandidate.charAt(i));
            if (candidate < prev) {
                roman -= candidate;
            } else {
                roman += candidate;
                prev = candidate;
            }
        }
        return roman;
    }

    private static final class Numbah implements Comparable<Numbah> {

        private final String actual;
        private final int number;

        private Numbah(String actual, int number) {
            this.actual = actual;
            this.number = number;
        }

        public static Numbah create(String actual, int number) {
            return new Numbah(actual, number);
        }

        @Override
        public int compareTo(Numbah o2) {
            return getNumber() > o2.getNumber() ? 1 : o2.getNumber() == getNumber() ? 0 : -1;
        }

        public int getNumber() {
            return number;
        }

        public String getActual() {
            return actual;
        }

        @Override
        public String toString() {
            return getActual() + ":" + Integer.toString(getNumber());
        }
    }

}
