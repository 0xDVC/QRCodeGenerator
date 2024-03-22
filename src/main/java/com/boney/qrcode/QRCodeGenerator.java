package com.boney.qrcode;

import com.boney.qrcode.builder.QRCodeConfig;
import com.boney.qrcode.decoder.QRCodeDecoder;
import com.boney.qrcode.encoder.QRCodeEncoder;
import com.boney.qrcode.exception.QRCodeException;
import com.boney.qrcode.io.QRCodeFileReader;
import com.boney.qrcode.io.QRCodeFileWriter;
import com.boney.qrcode.model.QRCode;

import java.awt.image.BufferedImage;
import java.io.File;

public class QRCodeGenerator {
    private final QRCodeEncoder encoder;
    private final QRCodeDecoder decoder;
    private final QRCodeFileReader fileReader;
    private final QRCodeFileWriter fileWriter;

    public QRCodeGenerator(QRCodeEncoder encoder, QRCodeDecoder decoder, QRCodeFileReader fileReader, QRCodeFileWriter fileWriter) {
        this.encoder = encoder;
        this.decoder = decoder;
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    public QRCode generateQRCode(String text, QRCodeConfig config) throws QRCodeException {
        BufferedImage qrCodeImage = encoder.encode(text, config);
        return new QRCode(config);
    }

    public String decodeQRCode(BufferedImage qrCodeImage) throws QRCodeException {
        return decoder.decode(qrCodeImage);
    }

    public void saveQRCodeToFile(QRCode qrCode, File file) throws QRCodeException {
        fileWriter.writeToFile(qrCode, file);
    }

    public QRCode loadQRCodeFromFile(File file) throws QRCodeException {
        return fileReader.readFromFile(file);
    }
}