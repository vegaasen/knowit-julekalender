package com.vegaasen.fun.julekalender.knowit.y2016;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.nio.file.Files;

/**
 * En skøyen alv har gjemt pakkene til nissen og julaften står i fare!
 * Alven etterlot seg et kart over med et rødt kryss midt på finnmarksvidda med tekst 'start here'.
 * På baksiden av kartet er det instruksjoner som sier hvor du skal gå fra krysset.
 * Du har fått som oppgave å hjelpe nissen med å finne pakkene og redde julaften.
 * <p>
 * Skattekartet har veldig mange steg, men du ser kjapt at det bare består av 4 forskjellige instruksjoner,
 * å gå x antall meter nord (north), sør (south), øst (east), eller vest (west).
 * Du bestemmer deg for å lage et program som samler disse stegene og returnerer antall meter nord og antall meter vest,
 * hvor et negativt tall betyr motsatt retning.
 * <p>
 * Eksempel:
 * walk 10 meters north
 * walk 10 meters south
 * walk 10 meters west
 * walk 10 meters east
 * walk 3 meters north
 * walk 2 meters east
 * <p>
 * gir resultatet:
 * 3,-2
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 * @link http://pastebin.com/BZrAMcN2
 * @since 07.12.2016
 */
public class Seventh implements OJulMedDinGlede {

    private static final String FILE_CANDIDATE = "/2016/seventh.text";
    private static final String SPLIT = "\\s", NORTH = "north", SOUTH = "south", WEST = "west", EAST = "east";

    private static int north = 0, west = 0;

    @Override
    public void hohoho() {
        new MeasuredInvocation(7) {
            @Override
            public void what() {
                try {
                    Files.readAllLines(PathPrettifier.INSTANCE.getFormattedPath(FILE_CANDIDATE)).forEach(Seventh::filter);
                    System.out.println(String.format("North {%s}, West {%s}", north, west));
                } catch (Exception e) {
                    /* gulp */
                }
            }
        }.execute();
    }

    private static void filter(String direction) {
        String[] specification = direction.split(SPLIT);
        switch (specification[3]) {
            case NORTH:
                north = north + Integer.parseInt(specification[1]);
                break;
            case SOUTH:
                north = north - Integer.parseInt(specification[1]);
                break;
            case WEST:
                west = west + Integer.parseInt(specification[1]);
                break;
            case EAST:
                west = west - Integer.parseInt(specification[1]);
                break;
        }
    }

}
