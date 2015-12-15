package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;

import java.util.ArrayList;
import java.util.List;

/**
 * +------------------------+
 * ¦ 34 ¦ 21 ¦ 32 ¦ 41 ¦ 25 ¦
 * +----+----+----+----+----¦
 * ¦ 14 ¦ 42 ¦ 43 ¦ 14 ¦ 31 ¦
 * +----+----+----+----+----¦
 * ¦ 54 ¦ 45 ¦ 52 ¦ 42 ¦ 23 ¦
 * +----+----+----+----+----¦
 * ¦ 33 ¦ 15 ¦ 51 ¦ 31 ¦ 35 ¦
 * +----+----+----+----+----¦
 * ¦ 21 ¦ 52 ¦ 33 ¦ 13 ¦ 23 ¦
 * +------------------------+
 * <p>
 * Ovenfor finner du en tabell som skal tolkes som et skattekart. Verdiene i cellene er hint til hvor skatten ligger gjemt.
 * Hver celle inneholder en verdi mellom 11 og 55. For hver verdi representerer det mest signifikante sifferet radnummeret
 * og det minst signifikante sifferet kolonnenummeret til cellen som inneholder neste hint. Start i cellen øverst til venstre (1,1),
 * bruk hintene til å søke deg gjennom tabellen. Skatten er gjemt i den cellen hvor verdien er lik sine egne koordinater.
 * Svaret skal gis som en kommaseparert liste med veien til skatten der det første elementet er startcellen og det
 * siste elementet er målcellen.
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Fifteen implements OJulMedDinGlede {

    private static final int[][] MAZE = new int[][]{
            {34, 21, 32, 41, 25},
            {14, 42, 43, 14, 31},
            {54, 45, 52, 42, 23},
            {33, 15, 51, 31, 35},
            {21, 52, 33, 13, 23}
    };

    @Override
    public void hohoho() {
        List<Integer> coordinates = new ArrayList<>();
        new MeasuredInvocation(15) {
            @Override
            public void what() {
                int position = 1_1, current = 0;
                while (position != current) {
                    coordinates.add(position);
                    current = position;
                    int x = position / 10 - 1;
                    int y = position % 10 - 1;
                    position = MAZE[x][y];
                }
            }
        }.execute();
        System.out.println(coordinates);
    }

}
