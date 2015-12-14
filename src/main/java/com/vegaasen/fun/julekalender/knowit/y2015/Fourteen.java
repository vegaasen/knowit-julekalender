package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;

import java.util.HashMap;
import java.util.Map;

/**
 * I denne oppgaven skal vi forsøke å finne tall som kan leses likt når de blir rotert 180° (med andre ord; opp ned).
 * Sifrene vi kan tolke opp ned er 0, 1, 6, 8 og 9 og noen eksempler på tall som blir like opp ned er: 181, 916 og 8008.
 * <p>
 * Din oppgave er å finne antall heltall, fra og med 0 til og med 100 000, som kan leses likt opp ned.
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Fourteen implements OJulMedDinGlede {

    private static final long ROTATED_MAX = 100_000L;
    private static final Map<Character, String> MAPPER = new HashMap<>();

    static {
        MAPPER.put('0', "0");
        MAPPER.put('1', "1");
        MAPPER.put('8', "8");
        MAPPER.put('9', "6");
        MAPPER.put('6', "9");
    }

    @Override
    public void hohoho() {
        final long[] matches = {0};
        new MeasuredInvocation(14) {
            @Override
            public void what() {
                for (long i = 0; i < ROTATED_MAX; i++) {
                    if (isSimilarUpsideDown(i)) {
                        matches[0]++;
                    }
                }
            }
        }.execute();
        System.out.println(matches[0]);
    }

    private static boolean isSimilarUpsideDown(long candidate) {
        char[] chars = Long.toString(candidate).toCharArray();
        StringBuilder translated = new StringBuilder();
        for (char aChar : chars) {
            String juuuul = MAPPER.get(aChar);
            if (juuuul != null && !juuuul.isEmpty()) {
                translated.append(juuuul);
            }
        }
        return translated.length() > 0 && Long.parseLong(translated.reverse().toString()) == candidate;
    }

}
