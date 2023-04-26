package com.xalpol12.helper;

import java.nio.file.Paths;

public final class FilePathConstants {
    private FilePathConstants() {} //prevents instantiation

    private static final String ABSOLUTE_PATH = Paths.get("").toAbsolutePath().toString();
    private static final String RESOURCES_PATH =  "src/main/resources";
    public static final String XML_JOINING_FILE_PATH = RESOURCES_PATH + "/documents/xml/Joining_01.xml";
    public static final String JSON_FILE_PATH = RESOURCES_PATH + "/documents/json/imports/my_scene.json";

}
