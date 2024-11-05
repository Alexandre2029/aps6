package com.aps6.imagens;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Imagem {

    public BufferedImage retorna_img(String imgNome) throws IOException {

        File fileA
        = new File("C:/Users/elizi/OneDrive/Documentos/aps6/src/main/java/com/aps6/imagens/digitais/"
                + imgNome);
        return ImageIO.read(fileA) ;
    }


    public Boolean verificaDigital(BufferedImage imgA, BufferedImage imgB){

        int width1 = imgA.getWidth();
        int width2 = imgB.getWidth();
        int height1 = imgA.getHeight();
        int height2 = imgB.getHeight();
        double porcentagem =0;

        if ((width1 != width2) || (height1 != height2))

            System.out.println("Erro: Imagem com dimenções diferentes"
                    + " incompativel");
        else {
            long diferenca = 0;

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

                    diferenca += Math.abs(redA - redB);
                    diferenca += Math.abs(greenA - greenB);
                    diferenca += Math.abs(blueA - blueB);
                }
            }

            double total_pixels = width1 * height1 * 3;
            double mediaDaDiferencadePixels  = diferenca / total_pixels;
            porcentagem = (mediaDaDiferencadePixels / 255) * 100;
        }
        return porcentagem < 5;

    }
}
