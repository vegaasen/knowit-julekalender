package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class First implements OJulMedDinGlede {

    private static final Pattern WTF = Pattern.compile("^[a-z]{0,3}[0-9]{2,8}[A-Z]{3,}.*$");
    private static final String FILE_CANDIDATE = "/2015/1_F8z0JWqa.txt";

    public void hohoho() {
        new MeasuredInvocation(1) {
            @Override
            public void what() {
                try {
                    System.out.println(Files.readAllLines(PathPrettifier.INSTANCE.getFormattedPath(FILE_CANDIDATE)).parallelStream().filter(WTF.asPredicate()).count());
                } catch (IOException e) {
                    // *oh snoes*
                }
            }
        }.execute();
    }
}
