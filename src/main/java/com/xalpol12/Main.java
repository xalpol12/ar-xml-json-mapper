package com.xalpol12;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;

public class Main {

    private static final String RESOURCES_PATH = "src/main/resources";
    private static final String FILENAME = RESOURCES_PATH + "/documents/xml/sample-doc.xml";

    public static void main(String[] args) throws ParserConfigurationException, URISyntaxException {
        DocumentBuilderFactory dbBuilder = DocumentBuilderFactory.newInstance();
        DomParserSimpleTest parser = new DomParserSimpleTest(dbBuilder);
        parser.parse(FILENAME);
    }
}