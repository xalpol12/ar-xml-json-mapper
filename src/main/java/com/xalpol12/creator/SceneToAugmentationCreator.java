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

    public static Augmentation createAugmentation(String jsonFilePath, String xmlFilePath) throws IOException, JAXBException {
        Scene scene = readJSON(jsonFilePath);
        List<JSONObject> jsonObjects = scene.objects();                            // Unwrap JSON scene object

        List<Node> inputObjects = createIOObjects(jsonObjects);

        Augmentation aug = JAXBParser.unmarshall(xmlFilePath, Augmentation.class); // Create augmentation based on Joining_01.xml file
        AugmentationManager augManager = new AugmentationManager(aug);

        augManager.deleteAllInputObjects();                                     // Delete all currently added objects
        augManager.insertInputObjects(aug, inputObjects, scene.viewList());     // Insert user objects
        return aug;
    }

    private static Scene readJSON(String filepath) throws IOException {
        return JSONParser.parse(filepath);
    }

    private static List<Node> createIOObjects(List<JSONObject> jsonObjects) {
        List<Node> inputObjects = new ArrayList<>();
        for (JSONObject object : jsonObjects) {
            inputObjects.add(IOObjectCreator.create(object));
        }
        return inputObjects;
    }
}
