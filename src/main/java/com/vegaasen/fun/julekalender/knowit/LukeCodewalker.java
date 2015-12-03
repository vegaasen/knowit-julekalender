package com.vegaasen.fun.julekalender.knowit;

import com.google.common.collect.Lists;
import com.vegaasen.fun.julekalender.knowit.y2015.First;
import com.vegaasen.fun.julekalender.knowit.y2015.Second;
import com.vegaasen.fun.julekalender.knowit.y2015.Third;
import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class LukeCodewalker {

    public static void main(String... args) {
        useTheForce();
    }

    private static void useTheForce() {
        Lists.<OJulMedDinGlede>newArrayList(
                new First(),
                new Second(),
                new Third()
        ).forEach(OJulMedDinGlede::hohoho);
    }

}
