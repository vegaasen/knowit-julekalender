package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

/**
 * Et anagram er et ord som kan skrives om til et annet ord ved å omrokere bokstavene.
 * Hvor mange av ordene totalt i ordlista http://pastebin.com/sGbqMyCa er anagrammer av andre ord i lista?
 * Merk at vi kun er ute etter ord i lista, ikke ord som er sammensatt av flere ord.
 * Eksempel input: acre, care, race, agnes, senga, eple
 * Eksempel output: 5 (dvs alle unntatt eple er et anagram av et annet ord i lista)
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Fifth implements OJulMedDinGlede {

    private static final String WTF = "/2015/5_anagramlist.txt";
    private static final List<String> ANAGRAMZ;

    static {
        List<String> what = Collections.emptyList();
        try {
            what = Files.readAllLines(PathPrettifier.INSTANCE.getFormattedPath(WTF));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ANAGRAMZ = what;
    }

    @Override
    public void hohoho() {
        System.out.println(String.format("Anagramz {%s}", "unsolved"));
    }

}
