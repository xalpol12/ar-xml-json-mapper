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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class SceneToAugmentationCreator {
    private static List<Node> inputObjects;
    private static List<Node> outputObjects;
    private static Augmentation aug;
    private static AugmentationManager augManager;

    public static Augmentation createAugmentation(String jsonFilePath, String xmlFilePath) throws IOException, JAXBException, URISyntaxException {
        initVariables(xmlFilePath);

        Scene scene = readJSON(jsonFilePath);
        List<JSONObject> jsonObjects = scene.getObjects();

        createIOObjects(jsonObjects);

        deleteAllPreviousObjects();
        insertAllObjects(scene.getViewList());

        return aug;
    }

    private static void initVariables(String xmlFilePath) throws JAXBException, URISyntaxException, IOException {
         inputObjects = new ArrayList<>();
         outputObjects = new ArrayList<>();
         aug = JAXBParser.unmarshallFromRelativePath(xmlFilePath, Augmentation.class);
         augManager = new AugmentationManager(aug);
    }

    private static Scene readJSON(String filepath) throws IOException {
        return JSONParser.parse(filepath);
    }

    private static void createIOObjects(List<JSONObject> jsonObjects) {
        for (JSONObject object : jsonObjects) {
            Node node = IOObjectCreator.create(object);
            switch (object.getType()) {
                case "joining_inputs":
                    inputObjects.add(node);
                    break;
                case "joining_outputs":
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
            List<String> viewListCopy = new ArrayList<>(viewList);
            viewListCopy.remove("joining_outputs");
            augManager.insertInputObjects(aug, inputObjects, viewListCopy);
        }
        if (!outputObjects.isEmpty()) {
            List<String> viewListCopy = new ArrayList<>(viewList);
            viewListCopy.remove("joining_inputs");
            augManager.insertOutputObjects(aug, outputObjects, viewListCopy);
        }
    }
}
