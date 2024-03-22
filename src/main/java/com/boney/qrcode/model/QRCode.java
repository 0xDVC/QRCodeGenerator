package com.boney.qrcode.model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QRCode{
    private String text;
    private BufferedImage image;

    public QRCode(String text, BufferedImage logo) {
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
