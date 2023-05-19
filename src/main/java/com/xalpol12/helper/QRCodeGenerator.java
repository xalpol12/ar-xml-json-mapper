package com.xalpol12.helper;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QRCodeGenerator {
    private static final Pattern PATTERN = Pattern.compile("([^\\/]+?)\\.xml");
    private static final String FESTO_QR_PATH = "http://mes-pc.festo.systems/factory/apps/ar/scenes/MPS400/";

    public static void writeQRCodeImage(String fileName, String saveLocation) throws IOException, WriterException {
        BitMatrix qrMatrix = generateQRCodeImage(FESTO_QR_PATH + fileName);
        Files.createDirectories(Paths.get(saveLocation, "QRCodes"));        // creates directory QRCodes if one does not exist
        Path path = Paths.get(saveLocation, "QRCodes", extractTitleFromText(fileName));
        MatrixToImageWriter.writeToPath(qrMatrix, "png", path);
    }

    private static String extractTitleFromText(String qrCodeText) {
        Matcher m = PATTERN.matcher(qrCodeText);
        String title = m.find()? m.group(1) : null;
        return title + ".png";
    }

    private static BitMatrix generateQRCodeImage(String qrCodeText) throws IOException, WriterException {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        return barcodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, 400, 400);
    }
}
