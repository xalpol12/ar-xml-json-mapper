package com.xalpol12;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;

    DomParser(DocumentBuilderFactory dbFactory) throws ParserConfigurationException {
        this.dbFactory = dbFactory;
        this.dBuilder = dbFactory.newDocumentBuilder();
    }

    void parseController(String fileName) throws IOException, SAXException {     //for testing purposes, delete later
        Document doc = readXMLFile(fileName);
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println(element.getNodeName());
            }
        }
    }

    Document readXMLFile(String fileName) throws IOException, SAXException {
        File file = FileHandler.getFile(fileName);
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        return doc;
    }








}
