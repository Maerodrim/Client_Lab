package com.example.Client.Service;

import com.example.Client.ClientApplication;
import com.example.Client.dto.Form;
import com.example.Client.rmi.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

@Service
@RequiredArgsConstructor
public class BluerService
{

    private static Bluer bluer;

    public static void setBluer(Bluer bluer) {
        BluerService.bluer = bluer;
    }

    public static File[] bluer(Form form) {
        String url = "rmi://localhost/";
        try {
            System.out.println("Client has started");
            File input = new File(form.getFile1() + ".jpg");
            BufferedImage inputImg = ImageIO.read(input);
            File output = new File(form.getFile2() + ".jpg");
            File output2 = new File("I:\\Client\\src\\main\\resources\\templates\\image1.jpg");
            File output3 = new File( "I:\\Client\\src\\main\\resources\\templates\\image2.jpg");
            ByteArrayOfImage baoi = new ByteArrayOfImage(inputImg);
            byte[] outBaoiByte = bluer.blurring(baoi.getByteOfImage());
            ByteArrayOfImage outBaoi  = new ByteArrayOfImage(outBaoiByte);
            BufferedImage outputImg = outBaoi.getBufferedImage();

            ImageIO.write(outputImg, "jpg", output);
            ImageIO.write(inputImg, "jpg", output2);
            ImageIO.write(outputImg, "jpg", output3);
            return new File[]{input, output};
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new File[2];
    }

    public static String getBaseName(String filename) {
        int index = filename.lastIndexOf(".");
        if (index == -1) return filename;
        return filename.substring(0, index);
    }
}