package com.boney.qrcode.exception;

public class QRCodeGenerationException extends QRCodeException {
    public QRCodeGenerationException(String message) {
        super(message);
    }

    public QRCodeGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
