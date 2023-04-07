package com.xalpol12;


import com.xalpol12.entity.Link;
import com.xalpol12.entity.Model;
import com.xalpol12.entity.ValueServer;

import javax.xml.bind.JAXBException;

public class Main {

    private static final String RESOURCES_PATH = "src/main/resources";
    private static final String FILENAME = RESOURCES_PATH + "/documents/xml/Joining_01.xml";
    private static final String TEST_FILENAME = RESOURCES_PATH + "/documents/xml/testfiles/test_model.xml";

    public static void main(String[] args) throws JAXBException {
        Model model = JAXBParser.unmarshallModel(TEST_FILENAME);
        System.out.println(model.toString());
    }
}