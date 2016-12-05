package com.vegaasen.fun.julekalender.knowit.y2016;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Kongen av Indonesia har som tradisjon å sende sine julehilsener kryptert til sine venner.
 * I år skjedde det en glipp og kongen sendte meldingen til alle i hele verden med en email adresse,
 * vi har også fått meldingen og trenger hjelp til å dekryptere den.
 * Med meldingen fulgte også følgende instruksjoner på hvordan den kan dekrypteres:
 * <p>
 * For å dekryptere meldingen må man først legge sammen parene i listen, ett par er første og siste element,
 * andre og nest siste element og så videre. Når du har alle verdiene kan du oversette disse til bokstaver, hvor a = 1 og z = 26.
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 * @link http://pastebin.com/xfX3msCL
 */
public class Sixth implements OJulMedDinGlede {

    private static final String FILE_CANDIDATE = "/2016/sixth.text";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public void hohoho() {
        new MeasuredInvocation(6) {
            @Override
            public void what() {
                try {
                    List<Integer> candidates = Stream.of(Files.readAllLines(PathPrettifier.INSTANCE.getFormattedPath(FILE_CANDIDATE)).stream().map(s -> s.split(",")).findFirst().orElse(new String[]{})).map(Sixth::romanToDecimal).collect(Collectors.toList());
                    String message = "";
                    int size = candidates.size();
                    for (int index = 0; index < size / 2; index++) {
                        message += ALPHABET.charAt(candidates.get(index) + candidates.get(size - index - 1) - 1);
                    }
                    System.out.println(message);
                } catch (IOException e) {
                    /* gulp */
                }
            }
        }.execute();
    }

    private static int romanToDecimal(String romanNumeral) {
        int decimal = 0, lastNumber = 0;
        for (int x = romanNumeral.length() - 1; x >= 0; x--) {
            char convertToDecimal = romanNumeral.charAt(x);
            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;
                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;
                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;
                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;
                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;
                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;
                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return decimal;
    }

    private static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
}
