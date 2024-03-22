package com.boney.qrcode.io;

import com.boney.qrcode.decoder.QRCodeDecoder;
import com.boney.qrcode.decoder.QRCodeDecoderImpl;
import com.boney.qrcode.exception.QRCodeException;
import com.boney.qrcode.model.QRCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRCodeFileReader {
    public QRCode readFromFile(File file) throws QRCodeException {
        try {
            BufferedImage image = ImageIO.read(file);
            if (image == null) {
                throw new QRCodeException("Failed to read image from file: " + file.getAbsolutePath());
            }

            QRCodeDecoder decoder = new QRCodeDecoderImpl();
            String text = decoder.decode(image);

            int size = 300;
            Color color = Color.WHITE;
            int errorCorrectionLevel = 0;

            return new QRCode(text, size, color, null, errorCorrectionLevel);
        } catch (IOException e) {
            throw new QRCodeException("Error reading file: " + file.getAbsolutePath(), e);
        } catch (QRCodeException e) {
            throw new QRCodeException("Error decoding QR code from file: " + file.getAbsolutePath(), e);
        }
    }
}