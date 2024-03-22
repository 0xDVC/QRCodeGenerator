package com.boney.qrcode.util;

import com.boney.qrcode.model.QRCode;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QRCodeUtil {
    public static BufferedImage generateQRCodeImage(QRCode qrCode) {
        if (qrCode == null || qrCode.getImage() == null) {
            return null;
        }

        BufferedImage qrCodeImage = qrCode.getImage();
        int width = qrCodeImage.getWidth();
        int height = qrCodeImage.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(qrCode.getColor());
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.BLACK);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (qrCodeImage.getRGB(x, y) == Color.BLACK.getRGB()) {
                    graphics.fillRect(x, y, 1, 1);
                }
            }
        }

        if (qrCode.getLogo() != null) {
            int logoWidth = qrCode.getLogo().getWidth();
            int logoHeight = qrCode.getLogo().getHeight();
            int x = (width - logoWidth) / 2;
            int y = (height - logoHeight) / 2;
            graphics.drawImage(qrCode.getLogo(), x, y, null);
        }

        graphics.dispose();
        return image;
    }
}
