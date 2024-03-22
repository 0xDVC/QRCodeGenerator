package com.boney.qrcode.exception;

public class QRCodeDecodingException extends QRCodeException{
    public QRCodeDecodingException(String message) {
        super(message);
    }

    public QRCodeDecodingException(String message, Throwable cause) {
        super(message, cause);
    }
}
