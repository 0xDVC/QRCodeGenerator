package com.boney.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.Map;


public class QRCodeGenerator {
    private File outputFile;
    private String text;
    private String format;
    private int size;
    private String outputFilePath;

    public QRCodeGenerator(String text, String format, int size, String outputFilePath, String outputFile) {
        this.text = text;
        this.format = format;
        this.size = size;
        this.outputFilePath = outputFilePath;


        if (this.outputFilePath != null) {
            this.outputFilePath = Paths.get(System.getProperty("user.dir"), this.outputFile + "." + format).toString();
        } else {
            this.outputFilePath = Paths.get(System.getProperty("user.dir"), (outputFile == null ? "qr.":(outputFile+'.')) + format).toString();
        }
    }

    public void generateQrCode() throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, ErrorCorrectionLevel> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, size, size, hints);
        outputFile = new File(outputFilePath);
        MatrixToImageWriter.writeToPath(bitMatrix, format, outputFile.toPath());
    }

    @Override
    public String toString() {
        return String.format("\tText: %s\n\tFormat: %s\n\tSize: %d",text, format, size);
    }
}