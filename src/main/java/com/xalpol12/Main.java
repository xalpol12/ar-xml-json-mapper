package com.xalpol12;


import com.xalpol12.ioentity.components.ARNode;
import com.xalpol12.xmlentity.*;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;

public class Main {

    private static final String RESOURCES_PATH = "src/main/resources";
    private static final String FILENAME = RESOURCES_PATH + "/documents/xml/Joining_01.xml";
    private static final String TEST_FILENAME = RESOURCES_PATH + "/documents/xml/Measuring_01.xml";

    public static void main(String[] args) throws JAXBException, TransformerException {
//        Augmentation augmentation = JAXBParser.unmarshall(TEST_FILENAME, Augmentation.class);
////        System.out.println(augmentation.toString());
//        JAXBParser.marshall(augmentation, "newFile.xml");

        Node node = new Node();
        node.setTx(-257.8f);
        node.setTy(-48f);
        node.setTz(189.6f);
    }
}