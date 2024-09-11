package com.aps6.imagens;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Imagem {
    public BufferedImage retorna_img(String imgName) throws IOException {

        File fileA
        = new File("C:/Users/elizi/OneDrive/Documentos/aps6/src/main/java/com/aps6/imagens/digitais/"
                + imgName);
        BufferedImage img = ImageIO.read(fileA);
        return img;
    }

    public String difereca(BufferedImage imgA, BufferedImage imgB){

        int width1 = imgA.getWidth();
        int width2 = imgB.getWidth();
        int height1 = imgA.getHeight();
        int height2 = imgB.getHeight();
        double percentage =0;

        if ((width1 != width2) || (height1 != height2))

            System.out.println("Error: Images dimensions"
                    + " mismatch");
        else {
            long difference = 0;

            for (int y = 0; y < height1; y++) {
                for (int x = 0; x < width1; x++) {

                    int rgbA = imgA.getRGB(x, y);
                    int rgbB = imgB.getRGB(x, y);
                    int redA = (rgbA >> 16) & 0xff;
                    int greenA = (rgbA >> 8) & 0xff;
                    int blueA = (rgbA)&0xff;
                    int redB = (rgbB >> 16) & 0xff;
                    int greenB = (rgbB >> 8) & 0xff;
                    int blueB = (rgbB)&0xff;

                    difference += Math.abs(redA - redB);
                    difference += Math.abs(greenA - greenB);
                    difference += Math.abs(blueA - blueB);
                }
            }

            double total_pixels = width1 * height1 * 3;
            double avg_different_pixels  = difference / total_pixels;
            percentage = (avg_different_pixels / 255) * 100;
        }
        if(percentage < 10)
            return "ACESSO LIBERADO";
            else
                return "ACESSO NEGADO";

    }
}
