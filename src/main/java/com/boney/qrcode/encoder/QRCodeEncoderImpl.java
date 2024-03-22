package com.boney.qrcode.encoder;

import com.boney.qrcode.builder.QRCodeConfig;
import com.boney.qrcode.exception.QRCodeException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;

public class QRCodeEncoderImpl implements QRCodeEncoder {
    @Override
    public BufferedImage encode(String text, QRCodeConfig config) throws QRCodeException {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
            hints.put(EncodeHintType.ERROR_CORRECTION, getErrorCorrectionLevel(config.getErrorCorrectionLevel()));
            hints.put(EncodeHintType.MARGIN, 0);

            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, config.getSize(), config.getSize(), hints);

            BufferedImage qrCodeImage = new BufferedImage(config.getSize(), config.getSize(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = qrCodeImage.createGraphics();
            graphics.setColor(config.getColor());
            graphics.fillRect(0, 0, config.getSize(), config.getSize());
            graphics.setColor(Color.BLACK);

            for (int x = 0; x < config.getSize(); x++) {
                for (int y = 0; y < config.getSize(); y++) {
                    if (bitMatrix.get(x, y)) {
                        graphics.fillRect(x, y, 1, 1);
                    }
                }
            }

            if (config.getLogo() != null) {
                int logoWidth = config.getLogo().getWidth();
                int logoHeight = config.getLogo().getHeight();
                int x = (config.getSize() - logoWidth) / 2;
                int y = (config.getSize() - logoHeight) / 2;
                graphics.drawImage(config.getLogo(), x, y, null);
            }

            graphics.dispose();
            return qrCodeImage;
        } catch (WriterException e) {
            throw new QRCodeException("Error encoding QR code", e);
        }
    }

    private ErrorCorrectionLevel getErrorCorrectionLevel(int level) {
        return switch (level) {
            case 0 -> ErrorCorrectionLevel.L;
            case 1 -> ErrorCorrectionLevel.M;
            case 2 -> ErrorCorrectionLevel.Q;
            case 3 -> ErrorCorrectionLevel.H;
            default -> ErrorCorrectionLevel.L;
        };
    }
}