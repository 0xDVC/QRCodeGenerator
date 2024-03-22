package com.boney.qrcode.decoder;

import com.boney.qrcode.exception.QRCodeException;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import java.awt.image.BufferedImage;

public class QRCodeDecoderImpl implements QRCodeDecoder {
    @Override
    public String decode(BufferedImage qrCodeImage) throws QRCodeException {
        try {
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(qrCodeImage)));
            MultiFormatReader reader = new MultiFormatReader();
            Result result = reader.decode(binaryBitmap);
            return result.getText();
        } catch (NotFoundException e) {
            throw new QRCodeException("QR code not found or cannot be decoded", e);
        } catch (Exception e) {
            throw new QRCodeException("Error decoding QR code", e);
        }
    }
}