package com.boney.qrcode.io;

import com.boney.qrcode.exception.QRCodeException;
import com.boney.qrcode.model.QRCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRCodeFileWriter {
    public void writeToFile(QRCode qrCode, File file) throws QRCodeException {
        try {
            BufferedImage image = qrCode.getImage();
            if (image == null) {
                throw new QRCodeException("QR code image is null");
            }

            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            throw new QRCodeException("Error writing QR code to file: " + file.getAbsolutePath(), e);
        }
    }
}
