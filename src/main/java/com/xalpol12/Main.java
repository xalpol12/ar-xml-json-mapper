package com.xalpol12;


import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import java.net.URISyntaxException;

public class Main {

    private static final String RESOURCES_PATH = "src/main/resources";
    private static final String FILENAME = RESOURCES_PATH + "/documents/xml/Joining_01.xml";

    public static void main(String[] args) throws ParserConfigurationException, URISyntaxException, IOException, SAXException {
        DocumentBuilderFactory dbBuilder = DocumentBuilderFactory.newInstance();
        DomParser parser = new DomParser(dbBuilder);
        parser.parseController(FILENAME);
    }
}