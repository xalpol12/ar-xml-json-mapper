package com.xalpol12.helper;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class FileHandler {
    public static File getFile(String fileName) throws URISyntaxException {
        URL url = FileHandler.class.getClassLoader().getResource(fileName);
        return new File(url.toURI());
    }
}