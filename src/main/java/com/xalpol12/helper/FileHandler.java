package com.xalpol12.helper;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class FileHandler {
    public static File getFile(String fileName) {
        return new File(fileName);
    }

    public static InputStream getRelativePathFile(String fileName) throws URISyntaxException, IOException {
        return FileHandler.class.getClassLoader().getResourceAsStream(fileName);
    }
}