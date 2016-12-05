package com.vegaasen.fun.julekalender.knowit.y2016;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Third implements OJulMedDinGlede {

    private static final String FILE_CANDIDATE = "/2016/third.text";


    @Override
    public void hohoho() {
        new MeasuredInvocation(3) {
            @Override
            public void what() {
                try {
                    List<List<String>> lines = new ArrayList<>();
                    Map<String, Integer> like = new HashMap<>(), hates = new HashMap<>();
                    Files.readAllLines(PathPrettifier.INSTANCE.getFormattedPath(FILE_CANDIDATE))
                            .parallelStream()
                            .forEach(s -> lines.add((Stream.of(s.split("\\s")).collect(Collectors.toList()))));
                    for (List<String> line : lines) {
                        if (line != null) {
                            if (line.contains("hates")) {
                                String candidate = line.get(0);
                                hates.put(candidate, hates.containsKey(candidate) ? hates.get(candidate) + 1 : 1);
                            } else {
                                String candidate = line.get(1);
                                like.put(candidate, like.containsKey(candidate) ? like.get(candidate) + 1 : 1);
                            }
                        }
                    }
                    System.out.println(hates);
                    System.out.println(like);
                } catch (IOException e) {
                    // *oh snoes*
                }
            }
        }.execute();
    }

}
