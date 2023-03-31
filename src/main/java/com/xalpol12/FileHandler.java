package com.xalpol12;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

class FileHandler {
    public static File getFile(String fileName) {
        return new File(fileName);
    }
}