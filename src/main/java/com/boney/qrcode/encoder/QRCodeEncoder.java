package com.boney.qrcode.encoder;

import com.boney.qrcode.builder.QRCodeConfig;
import com.boney.qrcode.exception.QRCodeException;

import java.awt.image.BufferedImage;

public interface QRCodeEncoder {
    BufferedImage encode(String text, QRCodeConfig config) throws QRCodeException;
}
