package com.boney.qrcode.decoder;

import com.boney.qrcode.exception.QRCodeException;

import java.awt.image.BufferedImage;

public interface QRCodeDecoder {
    String decode(BufferedImage qrCodeImage) throws QRCodeException;
}
