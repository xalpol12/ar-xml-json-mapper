package com.xalpol12;

import com.xalpol12.creator.SceneToAugmentationCreator;
import com.xalpol12.entity.xmlentity.Augmentation;
import com.xalpol12.helper.FilePathConstants;
import com.xalpol12.parser.JAXBParser;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws JAXBException, TransformerException, IOException {
        Augmentation aug = SceneToAugmentationCreator.createAugmentation(
                FilePathConstants.JSON_FILE_PATH,
                FilePathConstants.XML_JOINING_FILE_PATH);
        JAXBParser.marshall(aug, "testFileFromJSONPrefixAndTransmitterChanged.xml");
//        Augmentation aug = JAXBParser.unmarshall("Joining_01.xml", Augmentation.class);
//        JAXBParser.marshall(aug, "Joining_01_parsed.xml");
    }
}