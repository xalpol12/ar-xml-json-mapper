package com.xalpol12;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class DomParserSimpleTest {
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;

    DomParserSimpleTest(DocumentBuilderFactory dbFactory) throws ParserConfigurationException {
        this.dbFactory = dbFactory;
        this.dBuilder = dbFactory.newDocumentBuilder();
    }

    void parse(String fileName) {
        try {
//            InputStream stream = FileHandler.getFileInputStream(fileName);
            File file = FileHandler.getFile(fileName);
            Document doc = dBuilder.parse(file);
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("student");
            System.out.println("--------------------");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("\nCurrent element : " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    System.out.println("Student roll no : "
                    + element.getAttribute("rollno"));
                    System.out.println("First name : "
                    + element
                            .getElementsByTagName("firstname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Last name : "
                            + element
                            .getElementsByTagName("lastname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Nick name : "
                            + element
                            .getElementsByTagName("nickname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Marks : "
                            + element
                            .getElementsByTagName("marks")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
