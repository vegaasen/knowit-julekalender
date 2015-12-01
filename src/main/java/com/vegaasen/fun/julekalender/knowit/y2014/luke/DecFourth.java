package com.vegaasen.fun.julekalender.knowit.y2014.luke;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public final class DecFourth {

    private static final String DATE_FORMAT = "dd.MM.yyyy";

    public static void main(String... args) {
        //doIt();
        doItOldStyle();
    }

    private static void doIt() {
        try {
            final Path what = Paths.get(ClassLoader.getSystemResource("kilma_data_blindern.txt").toURI());
            try (Stream<String> blindernData = Files.lines(what)) {
                Optional<String> candidate = blindernData
                        .parallel()
                        .filter(s -> s.indexOf("       ", 30) == 0)
                        .findFirst();
                System.out.println(candidate.isPresent() ? candidate.get() : "Not found :)");
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static void doItOldStyle() {
        try {
            Path path = Paths.get(ClassLoader.getSystemResource("kilma_data_blindern.txt").toURI());
            List<String> conditions = Files.readAllLines(path);
            if (conditions != null && !conditions.isEmpty()) {
                for (final String line : conditions) {
                    String trimmed = line.replaceAll("\\p{Z}", "");
                    trimmed = trimmed.substring(5, trimmed.length() - 1);
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
                    LocalDate localDate = LocalDate.parse(trimmed.substring(0, 10), dateTimeFormatter);
                    if (localDate != null) {

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
