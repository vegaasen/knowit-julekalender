package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filen http://pastebin.com/sJVZp7BH inneholder liste av tall hvor det første tallet er prisen på en aksje på dag 1,
 * og neste tallet er prisen på dag 2, osv. Dette er den samme lista som i luke 2.
 * <p>
 * Gitt at du har lov å gjøre nøyaktig to (2) transaksjoner, hva er den høyeste mulige profitten du kan oppnå?
 * <p>
 * En transaksjon vil si at du kjøper en aksje på en dag, for å så selge den igjen et vilkårlig antall dager senere.
 * <p>
 * Det finnes to begrensninger:
 * <p>
 * Du er nødt å selge den første aksjen før du kan kjøpe den andre aksjen.
 * Du har ikke lov å kjøpe og selge en aksje på samme dag. Det vil si at du må vente til minst dagen etter du fullfører den
 * første transaksjonen før du kan starte den andre.
 * <p>
 * Svaret skal oppgis med fire desimaler, samt bruke punktum som desimalskilletegn. Eksempel: 12.3450
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Tenth implements OJulMedDinGlede {

    private static final List<Double> WHAT;

    static {
        List<Double> whats = new ArrayList<>();
        try {
            whats.addAll(Files.readAllLines(PathPrettifier.INSTANCE.getFormattedPath("/2015/10_sJVZp7BH.txt")).parallelStream().map(Double::parseDouble).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        WHAT = whats;
    }

    @Override
    public void hohoho() {
        final double[] awsomeBuy = {0d};
        new MeasuredInvocation(10) {
            @Override
            public void what() {
                awsomeBuy[0] = getBestBuy(WHAT) + getBestBuy(WHAT.subList(330, WHAT.size()));
            }
        }.execute();
        System.out.println(String.format("Profit {%.4f}", awsomeBuy[0]));
    }

    private static double getBestBuy(List<Double> what) {
        double bestBuy = 0d;
        for (int stockIn = 0; stockIn < what.size(); stockIn++) {
            for (int stockOut = stockIn + 1; stockOut < what.size(); stockOut++) {
                double candidateBestBuy = what.get(stockOut) - what.get(stockIn);
                if (candidateBestBuy > bestBuy) {
                    bestBuy = candidateBestBuy;
                }
            }
        }
        return bestBuy;
    }

}
