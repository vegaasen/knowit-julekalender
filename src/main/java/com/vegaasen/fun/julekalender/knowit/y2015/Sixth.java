package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;

/**
 * Gitt at vi har n par parenteser, hvor mange kombinasjoner av balanserte parenteser (dvs alle åpne parenteser er lukket) kan en lage?
 * Eksempel:
 * Gitt n=3, har vi følgende kombinasjoner som gir balanserte parenteser:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * Altså fem ulike måter.
 * <p>
 * Hvor mange velformede kombinasjoner finnes det for n = 13?
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Sixth implements OJulMedDinGlede {

    private static final char R = '(', L = ')';
    private static final String EMPTY = "";

    private int what = 0;

    @Override
    public void hohoho() {
        return;
//        printOutput(13);
//        System.out.println(what);
    }

    private void printOutput(int input) {
        String str = "{";
        int spacesCovered = 1;
        int noOfOpenBraces = 1;
        printParenth(str, spacesCovered, noOfOpenBraces, input);
    }

    public void printParenth(String str, int spacesCovered, int noOfOpenBraces, int input) {
        int noOfCloseBraces = spacesCovered - noOfOpenBraces;
        if (noOfOpenBraces == input) {
            for (int i = 1; i <= 2 * input - spacesCovered; i++) {
                str = str + "}";
            }
            System.out.println(str);
            what++;
        } else {
            if (noOfCloseBraces < noOfOpenBraces) {
                int tempSpaceCovered = spacesCovered;
                printParenth(str + "}", ++tempSpaceCovered, noOfOpenBraces, input);
            }
            printParenth(str + "{", ++spacesCovered, ++noOfOpenBraces, input);
        }

    }


}
