package com.boney.qrcode.builder;

import com.boney.qrcode.model.QRCode;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface QRCodeBuilder {
    QRCodeBuilder withText(String text);
    QRCodeBuilder withErrorCorrectionLevel(int level);
    QRCodeBuilder withColor(Color color);
    QRCodeBuilder withLogo(BufferedImage logo);
    QRCode build();
}
