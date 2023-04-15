package com.xalpol12;

import com.xalpol12.helpers.ARObjectHelper;
import com.xalpol12.helpers.AugmentationManager;
import com.xalpol12.xmlentity.Augmentation;
import com.xalpol12.xmlentity.Node;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.util.List;

public class Main {

    private static final String RESOURCES_PATH = "src/main/resources";
    private static final String FILENAME = RESOURCES_PATH + "/documents/xml/Joining_01.xml";
    private static final String TEST_FILENAME = RESOURCES_PATH + "/documents/xml/Joining_01.xml";

    public static void main(String[] args) throws JAXBException, TransformerException {
        Augmentation augmentation = JAXBParser.unmarshall(TEST_FILENAME, Augmentation.class);
//        JAXBParser.marshall(augmentation, "newFile.xml");
        String view = "joining_inputs,joining_g1bg1Details_i,joining_g1bg2Details_i,joining_g1bg3Details_i,joining_g1bg4Details_i,joining_g2bg1Details_i,joining_x1fk1Details_i,joining_g2bg2Details_i,joining_g2bg3Details_i,joining_x1xg2Details_i,joining_x1fk2Details_i,joining_g3bp1Details_i,joining_g3bg3Details_i,joining_g3bg2Details_i,joining_g3bg1Details_i";
        Node newObject = ARObjectHelper.create(view, "G1BG1", -100.8f, -100f, 100f);
//        JAXBParser.marshall(node, "g1bg2_from_object.xml");
        AugmentationManager.insertObjects(augmentation, List.of(newObject));
        JAXBParser.marshall(augmentation, "fileWithAdditionalObject.xml");
    }
}