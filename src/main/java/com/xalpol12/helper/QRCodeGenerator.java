package com.xalpol12.helper;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QRCodeGenerator {
    private static final Pattern p = Pattern.compile("/([^/]+?)\\.xml");

    public static void WriteQRCodeImage(String qrCodeText) {

        MatrixToImageWriter.writeToPath(bitMatrix, ".jpg", path);
    }

    private static String ExtractTitleFromText(String qrCodeText) {

    }

    private static BufferedImage GenerateQRCodeImage(String qrCodeText) throws IOException, WriterException {
        Matcher m = p.matcher(qrCodeText);
        String title = m.group(0);

        Path path = Paths.get(title);

        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, 200, 200);

        return MatrixToImageWriter.writeToPath(bitMatrix, ".jpg", path);
    }
}
