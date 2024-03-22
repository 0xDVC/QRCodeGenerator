package com.boney.qrcode.exception;

public class QRCodeManipulationException extends QRCodeException{
    public QRCodeManipulationException(String message) {
        super(message);
    }

    public QRCodeManipulationException(String message, Throwable cause) {
        super(message, cause);
    }
}
