package com.xalpol12.creator;

import com.xalpol12.entity.jsonentity.JSONObject;
import com.xalpol12.entity.jsonentity.Scene;
import com.xalpol12.entity.xmlentity.Augmentation;
import com.xalpol12.entity.xmlentity.Node;
import com.xalpol12.helper.AugmentationManager;
import com.xalpol12.parser.JAXBParser;
import com.xalpol12.parser.JSONParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneToAugmentationCreator {
    private static List<Node> inputObjects;
    private static List<Node> outputObjects;
    private static Augmentation aug;
    private static AugmentationManager augManager;

    public static Augmentation createAugmentation(String jsonFilePath, String xmlFilePath) throws IOException, JAXBException {
        initVariables(xmlFilePath);

        Scene scene = readJSON(jsonFilePath);
        List<JSONObject> jsonObjects = scene.getObjects();

        createIOObjects(jsonObjects);

        deleteAllPreviousObjects();
        insertAllObjects(scene.getViewList());

        return aug;
    }

    private static void initVariables(String xmlFilePath) throws JAXBException {
         inputObjects = new ArrayList<>();
         outputObjects = new ArrayList<>();
         aug = JAXBParser.unmarshall(xmlFilePath, Augmentation.class);
         augManager = new AugmentationManager(aug);
    }

    private static Scene readJSON(String filepath) throws IOException {
        return JSONParser.parse(filepath);
    }

    private static void createIOObjects(List<JSONObject> jsonObjects) {
        for (JSONObject object : jsonObjects) {
            Node node = IOObjectCreator.create(object);
            switch (object.getType()) {
                case "joining_input":
                    inputObjects.add(node);
                    break;
                case "joining_output":
                    outputObjects.add(node);
                    break;
            }
        }
    }

    private static void deleteAllPreviousObjects() {
        augManager.deleteAllInputObjects();
        augManager.deleteAllOutputObjects();
    }

    private static void insertAllObjects(List<String> viewList) {
        if (!inputObjects.isEmpty()) {
            augManager.insertInputObjects(aug, inputObjects, viewList);
        }
        if (!outputObjects.isEmpty()) {
            augManager.insertOutputObjects(aug, outputObjects, viewList);
        }
    }
}
