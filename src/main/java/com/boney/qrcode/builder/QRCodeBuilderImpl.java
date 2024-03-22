package com.boney.qrcode.builder;

import com.boney.qrcode.model.QRCode;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QRCodeBuilderImpl implements QRCodeBuilder {
    private final QRCodeConfig config;

    public QRCodeBuilderImpl() {
        config = new QRCodeConfig();
    }

    @Override
    public QRCodeBuilder withText(String text) {
        config.setText(text);
        return this;
    }

    @Override
    public QRCodeBuilder withErrorCorrectionLevel(int level) {
        config.setErrorCorrectionLevel(level);
        return this;
    }

    @Override
    public QRCodeBuilder withColor(Color color) {
        config.setColor(color);
        return this;
    }

    @Override
    public QRCodeBuilder withLogo(BufferedImage logo) {
        config.setLogo(logo);
        return this;
    }

    @Override
    public QRCodeBuilder withSize(int size) {
        config.setSize(size);
        return this;
    }

    @Override
    public QRCode build() {
        return new QRCode(config);
    }
}