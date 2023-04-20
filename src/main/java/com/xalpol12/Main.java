package com.xalpol12;

import com.xalpol12.creator.SceneToAugmentationCreator;
import com.xalpol12.entity.xmlentity.Augmentation;
import com.xalpol12.helper.StringManager;
import com.xalpol12.parser.JAXBParser;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws JAXBException, TransformerException, IOException {
        Augmentation aug = SceneToAugmentationCreator.createAugmentation(
                StringManager.JSON_FILE_PATH,
                StringManager.XML_JOINING_FILE_PATH);
        JAXBParser.marshall(aug, "testFileFromJSON.xml");
    }
}