package com.xalpol12.helper;

import com.google.zxing.WriterException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class QRCodeGeneratorTest {

    @Test
    void givenText_whenWriteQRCodeImage_thenFileExists() throws IOException, WriterException {
        // given
        String fileName = "Joining_01.xml";
        String fileDirectory = Paths.get(Paths.get("").toAbsolutePath().toString()).toString();
        Path completePath = Paths.get(fileDirectory, "QRCodes", "Joining_01.png");
//        "Joining_01.png"
        // when
        QRCodeGenerator.writeQRCodeImage(fileName, fileDirectory);

        // then
        assertTrue(Files.exists(completePath));
    }
}