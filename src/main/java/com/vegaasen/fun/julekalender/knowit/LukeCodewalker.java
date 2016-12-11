package com.vegaasen.fun.julekalender.knowit;

import com.vegaasen.fun.julekalender.knowit.y2016.Eleventh;
import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;

import java.util.stream.Stream;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class LukeCodewalker {

    public static void main(String... args) {
        useTheForceLuke();
    }

    private static void useTheForceLuke() {
        Stream.of(new Eleventh()).forEach(OJulMedDinGlede::hohoho);
    }

}
