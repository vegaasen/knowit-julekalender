package com.vegaasen.fun.julekalender.knowit.y2016;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;

/**
 * Som alle vet ligger vi an til et nytt Y2K i 2038. Da vil mange datostempel basert på unix epoch begynne å overflowe en standard 32 bit integer.
 * <p>
 * Unix epoch er definert som antallet sekunder siden 1970-01-01T00:00:00Z. Dette er en dato i formatet ISO 8601, du kan lese mer om dette her: https://en.wikipedia.org/wiki/ISO_8601
 * <p>
 * Her i Knowit er vi veldig interessert i å vite hva som skjer når det er en time ekstra i døgnet. Derfor lurer vi på når vi overflower en integerverdi hvis vi regner med at alle døgn siden starten av unix epoch hadde hatt 25 timer i stedet for 24.
 * <p>
 * Vi bruker den gregorianske kalenderen for oppgaven, og hvis det må gjøres antakelser om historikk og formater kan du ta utgangspunkt i historikk fra den norske kalenderen.
 * <p>
 * Svaret skal oppgis som et datostempel i samme format (og tidssone) som unix epoch er oppgitt ovenfor.
 * <p>
 * EDIT: Fikset en feil i datostempelet.
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 * @link https://julekalender.knowit.no/luker/c3HdjiEYz6CmaosyR
 * @since 11.12.16
 */
public class Eleventh implements OJulMedDinGlede {

    private static final int DAYS = (Integer.MAX_VALUE / 3600) / 25;

    @Override
    public void hohoho() {
        System.out.println("Ze datez iz: " +
                LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0, 0)
                        .plusDays(DAYS)
                        .plusSeconds(Integer.MAX_VALUE - (DAYS * 3600 * 25))
                        .atZone(ZoneOffset.UTC));
    }

}
