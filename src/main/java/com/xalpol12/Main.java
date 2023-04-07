package com.xalpol12;


import com.xalpol12.entity.Websocket;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import java.net.URISyntaxException;

public class Main {

    private static final String RESOURCES_PATH = "src/main/resources";
    private static final String FILENAME = RESOURCES_PATH + "/documents/xml/Joining_01.xml";
    private static final String TEST_FILENAME = RESOURCES_PATH + "/documents/xml/test.xml";

    public static void main(String[] args) throws JAXBException {
//        DocumentBuilderFactory dbBuilder = DocumentBuilderFactory.newInstance();
//        DomParser parser = new DomParser(dbBuilder);
//        parser.parseController(FILENAME);
        Websocket websocket = JAXBParser.unmarshall(TEST_FILENAME);
        System.out.println(websocket.toString());
    }
}