package com.vegaasen.fun.julekalender.knowit.y2016;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/**
 * I en cryptocurrency som f. eks. Bitcoin bestemmes balansen til en konto ut av historikken av transaksjoner. Det vil si at hvis historikken kun består av én transaksjon hvor addresse X mottok 10 penger, så sier vi at balansen til X er 10.Dersom det kommer en ny transaksjon fra X til Y hvor det sendes 7 penger, så er balansen til Y: 7 og X: 3.
 * <p>
 * I filen det lenkes til finnes det to typer transaksjoner. Den ene typen er som den første beskrevet her, hvor penger trykkes ut av intet, og en heldig adresse mottar en viss sum penger. I den andre typen går pengene fra en adresse til en annen.
 * <p>
 * Ved å holde rede på alle transaksjoner i filen http://pastebin.com/raw/2vstb018, hvor mange adresser har en balanse på mer enn 10 penger når samtlige transaksjoner er utført?
 * <p>
 * Alle transaksjoner er gyldige, så du slipper å validere dem.
 * <p>
 * Formatet i filen er:
 * <p>
 * None,9251b282-e1bc-4221-80d8-36b25826ebac,50
 * 9251b282-e1bc-4221-80d8-36b25826ebac,73b2dc61-24f4-4b0b-aca6-8c2d50b0e66c,38
 * <p>
 * Linje 1 sender 50 penger fra None til 9251b282-e1bc-4221-80d8-36b25826ebacLinje 2 sender 38 penger fra 9251b282-e1bc-4221-80d8-36b25826ebac til 73b2dc61-24f4-4b0b-aca6-8c2d50b0e66c
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 * @link https://julekalender.knowit.no/luker/68S5n2HAiJMm68t8c
 * @since 10.12.16
 */
public class Ninth implements OJulMedDinGlede {

    private static final String FILE_CANDIDATE = "/2016/ninth.text";
    private static final Map<String, Integer> REGISTER = new HashMap<>();

    @Override
    public void hohoho() {
        new MeasuredInvocation(9) {
            @Override
            public void what() {
                try {
                    Files.readAllLines(PathPrettifier.INSTANCE.getFormattedPath(FILE_CANDIDATE)).forEach(
                            line -> {
                                String[] candidate = line.split(",");
                                int money = Integer.parseInt(candidate[2]);
                                String issuer = candidate[0], receiver = candidate[1];
                                REGISTER.put(receiver, REGISTER.containsKey(receiver) ? REGISTER.get(receiver) + money : money);
                                if (!issuer.equalsIgnoreCase("none")) {
                                    REGISTER.put(issuer, REGISTER.containsKey(issuer) ? REGISTER.get(issuer) - money : -money);
                                }
                            }
                    );
                    System.out.println(REGISTER.values().stream().filter(i -> i > 10).count());
                } catch (Exception e) {
            /*gulp*/
                }
            }
        }.execute();
    }
}
