package com.vegaasen.fun.julekalender.knowit;

import com.google.common.collect.Lists;
import com.vegaasen.fun.julekalender.knowit.y2015.Eight;
import com.vegaasen.fun.julekalender.knowit.y2015.Fifth;
import com.vegaasen.fun.julekalender.knowit.y2015.First;
import com.vegaasen.fun.julekalender.knowit.y2015.Fourth;
import com.vegaasen.fun.julekalender.knowit.y2015.Ninth;
import com.vegaasen.fun.julekalender.knowit.y2015.Second;
import com.vegaasen.fun.julekalender.knowit.y2015.Seventh;
import com.vegaasen.fun.julekalender.knowit.y2015.Sixth;
import com.vegaasen.fun.julekalender.knowit.y2015.Tenth;
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
                new Third(),
                new Fourth(),
                new Fifth(),
                new Sixth(),
                new Seventh(),
                new Eight(),
                new Ninth(),
                new Tenth()
        ).forEach(OJulMedDinGlede::hohoho);
    }

}
