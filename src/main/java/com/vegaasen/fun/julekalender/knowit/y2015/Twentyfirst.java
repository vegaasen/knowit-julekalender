package com.vegaasen.fun.julekalender.knowit.y2015;

import com.google.common.collect.Sets;
import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Gitt to ord (start og slutt) og en ordliste (list).
 * Finn lengden av den korteste transformasjonssekvensen fra startordet til sluttordet.
 * Følgende regler gjelder for hver transformasjon:
 * Kun en bokstav kan endres om gangen
 * Hvert mellomord må finnes i ordlisten
 * <p>
 * For eksempel:
 * start = "pull", slutt = "pool", ordliste = ["peel", "poll", "ping", "push", "pool"]
 * Her er den korteste transformasjonssekvensen "pull" -> "poll" -> "pool", og denne sekvensen har lengde 3
 * <p>
 * Hva er sekvenslengden for startordet “sand”,  sluttordet “hold” og ordlisten som finnes på http://pastebin.com/LJX9cNvA?
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class TwentyFirst implements OJulMedDinGlede {

    private static final Set<String> WORDZ = new HashSet<>();
    private static final String START = "sand", END = "hold";

    static {
        Set<String> what = new HashSet<>();
        try {
            what = Files.readAllLines(PathPrettifier.INSTANCE.getFormattedPath("/2015/21_LJX9cNvA.txt")).parallelStream().collect(Collectors.toSet());
        } catch (Exception e) {
            /* gulp */
        }
        WORDZ.addAll(what);
    }


    @Override
    public void hohoho() {
        int[] result = new int[1];
        new MeasuredInvocation(21) {
            @Override
            public void what() {
                result[0] = transformationVerifyer(WORDZ, Sets.newHashSet(START), END);
            }
        }.execute();
        System.out.println(String.format("Shortest possible step is {%s}", result[0]));
    }

    public int transformationVerifyer(Set<String> words, Set<String> start, String end) {
        if (start.contains(end)) {
            return 1;
        }
        Set<String> candidates = words.parallelStream().filter(s -> start.stream().anyMatch(s1 -> verify(s, s1))).collect(Collectors.toSet());
        start.addAll(candidates);
        words.removeAll(candidates);
        return transformationVerifyer(words, start, end) + 1;
    }

    public boolean verify(final String endGame, final String candidate) {
        boolean moved = false;
        for (int i = 0; i < endGame.length(); i++) {
            if (endGame.charAt(i) != candidate.charAt(i)) {
                if (moved) {
                    return false;
                }
                moved = true;
            }
        }
        return true;
    }

}
