package com.boney.qrcode.builder;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QRCodeConfig {
    private String text;
    private int errorCorrectionLevel;
    private Color color;
    private BufferedImage logo;
    private int size;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getErrorCorrectionLevel() {
        return errorCorrectionLevel;
    }

    public void setErrorCorrectionLevel(int errorCorrectionLevel) {
        this.errorCorrectionLevel = errorCorrectionLevel;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BufferedImage getLogo() {
        return logo;
    }

    public void setLogo(BufferedImage logo) {
        this.logo = logo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}