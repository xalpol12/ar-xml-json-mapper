package com.xalpol12;

import com.google.zxing.WriterException;
import com.xalpol12.creator.SceneToAugmentationCreator;
import com.xalpol12.entity.xmlentity.Augmentation;
import com.xalpol12.helper.FilePathConstants;
import com.xalpol12.helper.QRCodeGenerator;
import com.xalpol12.helper.StringHelper;
import com.xalpol12.parser.JAXBParser;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String... args) throws JAXBException, TransformerException, IOException, WriterException {
        String saveLocation = args[0];
        for (int i = 1; i < args.length; i++) {
            Augmentation aug = SceneToAugmentationCreator.createAugmentation(
                    args[i],
                    FilePathConstants.XML_JOINING_FILE_PATH);
            String title = StringHelper.extractTitleFromFilePath(args[i]);
            JAXBParser.marshall(aug, saveLocation + File.separator + title);
            QRCodeGenerator.writeQRCodeImage(title, saveLocation);
        }
    }
}