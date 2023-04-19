package com.xalpol12;

import com.xalpol12.helpers.ARObjectHelper;
import com.xalpol12.helpers.AugmentationManager;
import com.xalpol12.jsonentity.Scene;
import com.xalpol12.xmlentity.Augmentation;
import com.xalpol12.xmlentity.Node;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    private static final String RESOURCES_PATH = "src/main/resources";
    private static final String FILENAME = RESOURCES_PATH + "/documents/xml/Joining_01.xml";
    private static final String TEST_FILENAME = RESOURCES_PATH + "/documents/xml/Joining_01.xml";
    private static final String view = "joining_inputs,joining_g1bg1Details_i,joining_g1bg2Details_i,joining_g1bg3Details_i,joining_g1bg4Details_i,joining_g2bg1Details_i,joining_x1fk1Details_i,joining_g2bg2Details_i,joining_g2bg3Details_i,joining_x1xg2Details_i,joining_x1fk2Details_i,joining_g3bp1Details_i,joining_g3bg3Details_i,joining_g3bg2Details_i,joining_g3bg1Details_i";
    private static final String jsonPath = RESOURCES_PATH + "/documents/json/imports/Scene_0.json";

    public static void main(String[] args) throws JAXBException, TransformerException, IOException {
//        Augmentation augmentation = JAXBParser.unmarshall(TEST_FILENAME, Augmentation.class);
//        AugmentationManager manager = new AugmentationManager(augmentation);
//
//        Node firstObject = ARObjectHelper.create(view, "G1BG1", -20f, -20f, 20f);
//        Node secondObject = ARObjectHelper.create(view, "G1BG1", -40f, -40f, 40f);
//        Node thirdObject = ARObjectHelper.create(view, "G1BG1", -60f, -60f, 60f);
////        manager.insertInputObjects(augmentation, List.of(firstObject, secondObject, thirdObject));
//        manager.deleteAllInputObjects(augmentation);
//
//        JAXBParser.marshall(augmentation, "fileWithAdditionalObject.xml");
        Scene scene = JSONParser.parse(jsonPath);
        System.out.println(scene.toString());
    }
}