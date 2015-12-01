package com.vegaasen.fun.julekalender.utils;

import com.google.common.base.Strings;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public enum PathPrettifier {

    INSTANCE;

    private static final String PATH_ILLEGAL = "/";

    public Path getFormattedPath(final String where) {
        if (Strings.isNullOrEmpty(where)) {
            throw new IllegalArgumentException();
        }
        String candidate = PathPrettifier.class.getResource(where).getPath();
        return Paths.get(candidate.contains(PATH_ILLEGAL) && !File.separator.equals(PATH_ILLEGAL) ? candidate.substring(1, candidate.length()).replaceAll(PATH_ILLEGAL, "\\\\") : candidate);
    }

}
