package com.xalpol12;

import com.google.zxing.WriterException;
import com.xalpol12.creator.SceneToAugmentationCreator;
import com.xalpol12.entity.xmlentity.Augmentation;
import com.xalpol12.helper.FilePathConstants;
import com.xalpol12.helper.QRCodeGenerator;
import com.xalpol12.helper.StringHelper;
import com.xalpol12.parser.JAXBParser;
import com.xalpol12.verifier.PathVerifier;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ArObjectMapper {
    /*  Serves as an adapter between generated json files
    *   and required by Festo Didactic AR App xml station files.
    *   Generates xml file and qr code for every supplied json file.
    *
    *   @param  first argument    an absolute save location path
    *   @param  next arguments    absolute path to json files, at least one is required
    * */
    public static void main(String... args) throws JAXBException, TransformerException, IOException, WriterException, URISyntaxException {
        if (isValidInput(args)) {
            String saveLocation = args[0];
            for (int i = 1; i < args.length; i++) {
                Augmentation aug = SceneToAugmentationCreator.createAugmentation(
                        args[i],
                        FilePathConstants.XML_JOINING_FILE_PATH);
                String title = StringHelper.extractTitleFromFilePath(args[i]);
                JAXBParser.marshall(aug, saveLocation + File.separator + title);
                QRCodeGenerator.writeQRCodeImage(title, saveLocation);
            }
            System.out.printf("%x file(s) converted successfully.", args.length - 1);
        }
    }

    private static boolean isValidInput(String... args) {
        if(args.length < 2) {
            System.out.println("Please provide at least 2 arguments: destination directory and .json file to parse");
            return false;
        }
        if (!PathVerifier.isValidDirectory(args[0])) {
            System.out.println("First argument is not a valid directory. Please provide correct directory as a first argument.");
            return false;
        }
        for (int i = 1; i < args.length; i++) {
            if (!PathVerifier.isJSONFile(args[i])) {
                System.out.printf("Argument #%x is incorrect, please provide a valid path to .json file.", i+1);
                return false;
            }
        }
        return true;
    }
}