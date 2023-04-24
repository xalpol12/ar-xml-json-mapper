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
        String qrCodeText = """
                http://mes-pc.festo.systems/factory/apps/ar/scenes/MPS400/Joining_01.xml 
                """;
        Path filePath = Paths.get(Paths.get("").toAbsolutePath().toString(),"Joining_01.png");

        // when
        QRCodeGenerator.writeQRCodeImage(qrCodeText);

        // then
        assertTrue(Files.exists(filePath));
    }
}