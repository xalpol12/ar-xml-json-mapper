package com.xalpol12.helper;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QRCodeGenerator {
    private static final Pattern PATTERN = Pattern.compile("([^\\/]+?)\\.xml");
    private static final String CURRENT_PATH = Paths.get("").toAbsolutePath().toString();

    public static void writeQRCodeImage(String qrCodeText) throws IOException, WriterException {
        Path path = Paths.get(CURRENT_PATH, extractTitleFromText(qrCodeText));  // TODO: Change path to user's destination path
        BitMatrix qrMatrix = generateQRCodeImage(qrCodeText);
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
