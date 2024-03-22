package com.boney.qrcode.io;

import com.boney.qrcode.builder.QRCodeConfig;
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

            QRCodeConfig config = new QRCodeConfig();

            config.setText(decoder.decode(image));
            config.setSize(300);
            config.setColor(Color.WHITE);
            config.setErrorCorrectionLevel(0);

            return new QRCode(config);
        } catch (IOException e) {
            throw new QRCodeException("Error reading file: " + file.getAbsolutePath(), e);
        } catch (QRCodeException e) {
            throw new QRCodeException("Error decoding QR code from file: " + file.getAbsolutePath(), e);
        }
    }
}