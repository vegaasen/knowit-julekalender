package com.vegaasen.fun.julekalender.knowit.y2016;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;

/**
 * Alle kjenner til leken hvor man går runden rundt og teller men må hoppe over (klappe e.l) alle tall som enten har 7 i seg eller er delig på 7. Et eksempel er gitt under der '( )' indikerer et slikt tall.
 * 1 2 3 4 5 6 ( ) 8 9 10 11 12 13 ( ) 15 16 ( ) 18 ...
 * <p>
 * Algemannens versjon av denne leken er å fylle inn alle disse '( )' med begynnelsen på tallrekken igjen. Et eksempel under er gitt (legg merke til det siste 1'tallet der..):
 * 1 2 3 4 5 6 (1) 8 9 10 11 12 13 (2) 15 16 (3) 18 19 20 (4) 22 23 24 25 26 (5) (6) 29 30 31 32 33 34 (1) 36 (8) 38 ..
 * <p>
 * Vi er ute etter hvilket tall som blir stående på plass nr 1337. Svaret oppgis uten '( )' rundt.
 * !OBS beklager en feil i løsningen, det er oppdatert nå så prøv igjen.
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Forth implements OJulMedDinGlede {

    private static final char DIVIDER = '7';
    private static final int ICH_BIN_DER_1337 = 1337;

    @Override
    public void hohoho() {
        new MeasuredInvocation(4) {
            @Override
            public void what() {
                int candidateOption = 0, candidate = 0;
                for (int index = 1; index <= ICH_BIN_DER_1337; index++) {
                    if (dividation(index)) {
                        if (dividation(++candidateOption)) {
                            ++candidate;
                            if (index == ICH_BIN_DER_1337) {
                                System.out.println(candidate);
                            }
                        }
                    }
                }
            }
        }.execute();
    }

    private boolean dividation(int candidate) {
        return Integer.toString(candidate).indexOf(DIVIDER) > -1 || candidate % 7 == 0;
    }
}
