package com.example.Client.rmi;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class ByteArrayOfImage implements Serializable {
    private byte[] byteOfImage;

    public ByteArrayOfImage(byte[] byteOfImage) {
        this.byteOfImage = byteOfImage;
    }

    public ByteArrayOfImage(BufferedImage image) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            byteOfImage = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBufferedImage() {
        try {
            return ImageIO.read(new ByteArrayInputStream(byteOfImage));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] getByteOfImage() {
        return byteOfImage;
    }
}