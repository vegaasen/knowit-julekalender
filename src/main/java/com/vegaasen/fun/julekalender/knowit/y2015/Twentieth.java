package com.vegaasen.fun.julekalender.knowit.y2015;

import com.google.common.collect.Lists;
import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;

import java.util.List;

/**
 * Unsolved. Started WAYYY to late on sunday (23:45) sleepy as hell...
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Twentieth implements OJulMedDinGlede {

    private static final Character[] CHARACTERS = new Character[]{'A', 'B', 'C', 'D', 'A'};
    private static final List<Character> LEGALS = Lists.newArrayList(CHARACTERS);
    private static final String WHAT = "FJKAUNOJDCUTCRHBYDLXKEODVBWTYPTSHASQQFCPRMLDXIJMYPVOHBDUGSMBLMVUMMZYHULSUIZIMZTICQORLNTOVKVAMQTKHVRIFMNTSLYGHEHFAHWWATLYAPEXTHEPKJUGDVWUDDPRQLUZMSZOJPSIKAIHLTONYXAULECXXKWFQOIKELWOHRVRUCXIAASKHMWTMAJEWGEESLWRTQKVHRRCDYXNTLDSUPXMQTQDFAQAPYBGXPOLOCLFQNGNKPKOBHZWHRXAWAWJKMTJSLDLNHMUGVVOPSAMRUJEYUOBPFNEHPZZCLPNZKWMTCXERPZRFKSXVEZTYCXFRHRGEITWHRRYPWSVAYBUHCERJXDCYAVICPTNBGIODLYLMEYLISEYNXNMCDPJJRCTLYNFMJZQNCLAGHUDVLYIGASGXSZYPZKLAWQUDVNTWGFFYFFSMQWUNUPZRJMTHACFELGHDZEJWFDWVPYOZEVEJKQWHQAHOCIYWGVLPSHFESCGEUCJGYLGDWPIWIDWZZXRUFXERABQJOXZALQOCSAYBRHXQQGUDADYSORTYZQPWGMBLNAQOFODSNXSZFURUNPMZGHTAJUJROIGMRKIZHSFUSKIZJJTLGOEEPBMIXISDHOAIFNFEKKSLEXSJLSGLCYYFEQBKIZZTQQXBQZAPXAAIFQEIXELQEZGFEPCKFPGXULLAHXTSRXDEMKFKABUTAABSLNQBNMXNEPODPGAORYJXCHCGKECLJVRBPRLHORREEIZOBSHDSCETTTNFTSMQPQIJBLKNZDMXOTRBNMTKHHCZQQMSLOAXJQKRHDGZVGITHYGVDXRTVBJEAHYBYRYKJAVXPOKHFFMEPHAGFOOPFNKQAUGYLVPWUJUPCUGGIXGRAMELUTEPYILBIUOCKKUUBJROQFTXMZRLXBAMHSDTEKRRIKZUFNLGTQAEUINMBPYTWXULQNIIRXHHGQDPENXAJNWXULFBNKBRINUMTRBFWBYVNKNKDFR";

    @Override
    public void hohoho() {
        String candidate = "", actuals = "", wow = "";
        int smallestSoFar = WHAT.length();
        for (char c : WHAT.toCharArray()) {
            if (LEGALS.contains(c)) {
                if (countOccurrences(actuals, 'A') <= 1) {
                    actuals += c;
                }
                if (actuals.length() == CHARACTERS.length) {
                    if (smallestSoFar > candidate.length()) {
                        smallestSoFar = candidate.length();
                        wow = candidate;
                    }
                    actuals = "";
                    candidate = "";
                }
            }
            if (!actuals.isEmpty()) {
                candidate += c;
            }
        }
        System.out.println(String.format("Smallest so far {%s}", wow));
    }

    public static int countOccurrences(String haystack, char needle) {
        int count = 0;
        for (char c : haystack.toCharArray()) {
            if (c == needle) {
                ++count;
            }
        }
        return count;
    }

}