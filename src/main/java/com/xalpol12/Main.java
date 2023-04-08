package com.xalpol12;


import com.xalpol12.entity.*;

import javax.xml.bind.JAXBException;

public class Main {

    private static final String RESOURCES_PATH = "src/main/resources";
    private static final String FILENAME = RESOURCES_PATH + "/documents/xml/Joining_01.xml";
    private static final String TEST_FILENAME = RESOURCES_PATH + "/documents/xml/Joining_01.xml";

    public static void main(String[] args) throws JAXBException {
        Augmentation augmentation = JAXBParser.unmarshall(TEST_FILENAME, Augmentation.class);
        System.out.println(augmentation.toString());
        JAXBParser.marshall(augmentation, "newFile.xml");
    }
}