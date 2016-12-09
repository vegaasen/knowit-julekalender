package com.vegaasen.fun.julekalender.knowit.y2016;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Stigespillet er et enkelt turbasert brettspill der to eller flere spillere beveger seg gjennom et brett for å komme fra start til mål.
 * Den første spilleren som havner i den siste ruta har vunnet.
 * For hver tur kaster en spiller en terning, og må bevege seg fremover like mange steg som terningen viser.
 * Rutene på brettet er fylt med stiger som går oppover eller nedover.
 * Hvis spilleren lander på en rute hvor en stige starter flyttes spilleren til ruta stigen peker på.
 * <p>
 * Anta et brett med 10 ganger 9 ruter og følgende sett med stiger:
 * [(3,17), (8,10), (15,44), (22,5), (39,56), (49,75), (62,45), (64,19), (65,73), (80,12), (87,79]
 * Formatet på denne lista er par med ruter i formatet [(fra, til), (fra, til) ...]
 * <p>
 * Videre vil denne runden av stigespillet bestå av 1337 spillere. Disse spillerne kaster følgende terningkast:
 * http:8080//pastebin.com/raw/dJ7cT4AF  Spiller 1 bruker linje 1 som kast, spiller 2 bruker linje 2, osv.
 * <p>
 * - Alle spillere starter i felt 1.
 * - Målfeltet er felt 90.
 * - Man spiller etter tur, og roterer til spiller 1 når man har kommet rundt. Spiller 1, 2, 3 ... 1336, 1337, 1, 2 ...
 * - Runden er over når en spiller havner på siste felt i brettet.
 * - Man må slå et nøyaktig antall for å komme til siste felt.
 * Slår man for høyt flyttes ikke brikken og man fortsetter med neste spiller.https://testkda2.azurewebsites.net/api/Values/5
 * <p>
 * Svaret du skal frem til kan finnes når en spiller lander i siste feltet på brettet.
 * Tallet er **det totale** antallet stiger som er brukt av alle spillere * nummeret på spilleren som vant.
 * <p>
 * Eksempelvis om spiller 3 vinner og det totale antallet stiger som ble brukt var 13 blir svaret: 39
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 * @link http://pastebin.com/raw/dJ7cT4AF
 * @since 8.12.2016
 */
public class Eight implements OJulMedDinGlede {

    private static final String FILE_CANDIDATE = "/2016/eight.text";

    private static final int[][] ZE_BOARD = {{3, 17}, {8, 10}, {15, 44}, {22, 5}, {39, 56}, {49, 75}, {62, 45}, {64, 19}, {65, 73}, {80, 12}, {87, 79}};
    private static final List<Integer> FIELDS = new ArrayList<>(90);

    @Override
    public void hohoho() {
        try {

            Files.readAllLines(PathPrettifier.INSTANCE.getFormattedPath(FILE_CANDIDATE));
        } catch (Exception e) {
            /*gulp*/
        }
    }

}
