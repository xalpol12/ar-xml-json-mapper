package com.xalpol12.verifier;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xalpol12.helper.FileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathVerifier {
    public static boolean isValidDirectory(String dir) {
        try {
            Path path = Paths.get(dir);
            if (Files.notExists(path) || !Files.isDirectory(path)) return false;
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }

    public static boolean isJSONFile(String file) {
        try {
            new ObjectMapper().readTree(FileHandler.getFile(file));
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
