/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class pdi {

    public pdi() {

    }

    private int gerarnivelcinza(int valor) {
        return valor | valor << 8 | valor << 16;
    }

    public BufferedImage espelhamentoHorizontal(BufferedImage image) {
        int tamanho_imagem = (image.getHeight() - 1);
        BufferedImage image_rotacionada = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color cor;
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                cor = new Color(image.getRGB(j, i));
                int rgb = cor.getRGB();
                image_rotacionada.setRGB(tamanho_imagem - j, i, rgb);
            }

        }
        return image_rotacionada;
    }

    public BufferedImage espelhamentoVertical(BufferedImage image) {
        int tamanho_imagem = (image.getHeight() - 1);
        BufferedImage image_rotacionada = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color cor;
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                cor = new Color(image.getRGB(j, i));
                int rgb = cor.getRGB();
                image_rotacionada.setRGB(j, tamanho_imagem - i, rgb);
            }

        }
        return image_rotacionada;
    }

    public BufferedImage rotacao90AntiHorario_(BufferedImage image) {
        int tamanho_imagem = (image.getHeight() - 1);
        BufferedImage image_rotacionada = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color cor;
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                cor = new Color(image.getRGB(j, i));
                int rgb = cor.getRGB();
                image_rotacionada.setRGB(i, tamanho_imagem - j, rgb);
            }

        }
        return image_rotacionada;
    }

    public BufferedImage rotacao90Horario_(BufferedImage image) {
        int tamanho_imagem = (image.getHeight() - 1);
        BufferedImage image_rotacionada = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color cor;
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                cor = new Color(image.getRGB(j, i));
                int rgb = cor.getRGB();
                image_rotacionada.setRGB(tamanho_imagem - i, j, rgb);
            }

        }
        return image_rotacionada;
    }

    public BufferedImage rotacao180(BufferedImage image) {
        int tamanho_imagem = (image.getHeight() - 1);
        BufferedImage image_rotacionada = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color cor;
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                cor = new Color(image.getRGB(j, i));
                int rgb = cor.getRGB();
                image_rotacionada.setRGB(tamanho_imagem - j, tamanho_imagem - i, rgb);
            }

        }
        return image_rotacionada;
    }

    public BufferedImage negativo(BufferedImage image) {
        int red = 0;
        int blue = 0;
        int green = 0;
        int rgb = 0;
        Color cor = null;
        BufferedImage image_negativa = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                cor = new Color(image.getRGB(i, j));
                red = (255 - cor.getRed());
                green = (255 - cor.getGreen());
                blue = (255 - cor.getBlue());
                cor = new Color(red, green, blue);
                rgb = cor.getRGB();
                image_negativa.setRGB(i, j, rgb);

            }

        }
        return image_negativa;
    }

    public BufferedImage pretoBranco(BufferedImage image) {
        int red = 0;
        int blue = 0;
        int green = 0;
        int rgb = 0;
        Color cor = null;
        BufferedImage image_negativa = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int nivel_cinza = (255 - (int) (image.getRGB(i, j) & 0x000000FF));
                nivel_cinza = gerarnivelcinza(nivel_cinza);
                image_negativa.setRGB(i, j, nivel_cinza);
            }

        }
        return image_negativa;
    }

    public BufferedImage amostragem(BufferedImage image, int mask) {
        if (256 % mask == 0) {

        } else {
            float resto = 256 % mask;
            resto = resto * mask;
            int currigi_erro = (int) Math.ceil(resto);
        }
        int red = 0;
        int blue = 0;
        int green = 0;
        int rgb = 0;
        Color cor = null;
        double media;
        BufferedImage image_amostrada = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < image.getHeight(); i = i + mask) {
            for (int j = 0; j < image.getWidth(); j = j + mask) {
                red = 0;
                blue = 0;
                green = 0;
                for (int mi = 0; mi < (i + mask); mi++) {
                    for (int mj = 0; j < (j + mask); mj++) {
                        if ((mj >= 0) && (mi >= 0) && (mj < image.getHeight()) && (mi < image.getWidth())) {
                            cor = new Color(image.getRGB(mi, mj));
                            red = red + cor.getRed();
                            green = green + cor.getGreen();
                            blue = blue + cor.getBlue();
                        }
                    }

                }
                media = mask * mask;
                red = (int) Math.ceil(red / media);
                green = (int) Math.ceil(green / media);
                blue = (int) Math.ceil(blue / media);
                cor = new Color(red, green, blue);
                rgb = cor.getRGB();
                for (int mi = (i); mi < (i + mask); mi++) {
                    for (int mj = (j); j < (j + mask); mj++) {
                        if ((mj >= 0) && (mi >= 0) && (mj < image.getHeight()) && (mi < image.getWidth())) {
                            image_amostrada.setRGB(mi, mj, rgb);
                        }
                    }

                }

            }

        }
        return image_amostrada;
    }

    public BufferedImage media(BufferedImage image, int parametro) {
        if (parametro % 2 == 0) {
            parametro++;
        }
        int mask = (int) Math.floor(parametro / 2);
        int red = 0;
        int blue = 0;
        int green = 0;
        int rgb = 0;
        Color cor = null;
        double media;
        BufferedImage image_amostrada = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < image.getHeight(); i = i + mask) {
            for (int j = 0; j < image.getWidth(); j = j + mask) {
                red = 0;
                blue = 0;
                green = 0;
                for (int mi = 0; mi < (i + mask); mi++) {
                    for (int mj = 0; j < (j + mask); mj++) {
                        if ((mj >= 0) && (mi >= 0) && (mj < image.getHeight()) && (mi < image.getWidth())) {
                            cor = new Color(image.getRGB(mi, mj));
                            red = red + cor.getRed();
                            green = green + cor.getGreen();
                            blue = blue + cor.getBlue();
                        }
                    }

                }
                media = parametro * parametro;
                red = (int) Math.ceil(red / media);
                green = (int) Math.ceil(green / media);
                blue = (int) Math.ceil(blue / media);
                cor = new Color(red, green, blue);
                rgb = cor.getRGB();
                for (int mi = (i); mi < (i + mask); mi++) {
                    for (int mj = (j); j < (j + mask); mj++) {
                        if ((mj >= 0) && (mi >= 0) && (mj < image.getHeight()) && (mi < image.getWidth())) {
                            image_amostrada.setRGB(mi, mj, rgb);
                        }
                    }

                }

            }

        }
        return image_amostrada;
    }

    public BufferedImage quantifizacao(BufferedImage image, int entrada) {
        BufferedImage image_quantizada = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        ArrayList faixa = new ArrayList<Integer>();
        double nivel_de_cor = 255.00;
        int intervalo_faixa = (int) Math.rint(nivel_de_cor / entrada);
        int i;
        for (i = 0; i < entrada; i++) {
            faixa.add(intervalo_faixa * i);
        }
        faixa.add(255);
        int red = 0;
        int blue = 0;
        int green = 0;
        int rgb = 0;
        Color cor;
        for (int y = 0; y < image.getHeight(); y++) {
            for (int j = 0; j < image.getWidth(); j++) {
                cor = new Color(image.getRGB(j, y));
                for (i = 0; i < entrada; i++) {

                    if (((int) cor.getRed() >= Integer.valueOf(faixa.get(i).toString())) && ((int) cor.getRed() <= Integer.valueOf(faixa.get(i).toString()))) {
                        red = Integer.valueOf(faixa.get(i + 1).toString());
                    }
                    if (((int) cor.getGreen() >= Integer.valueOf(faixa.get(i).toString())) && ((int) cor.getGreen() <= Integer.valueOf(faixa.get(i).toString()))) {
                        green = Integer.valueOf(faixa.get(i + 1).toString());
                    }
                    if (((int) cor.getBlue() >= Integer.valueOf(faixa.get(i).toString())) && ((int) cor.getBlue() <= Integer.valueOf(faixa.get(i).toString()))) {
                        blue = Integer.valueOf(faixa.get(i + 1).toString());
                    }
                }
                cor = new Color(red, green, blue);
                rgb = cor.getRGB();
                image_quantizada.setRGB(j, y, rgb);

            }

        }
        return image_quantizada;

    }

//    private int[][] getBinary(Bitmap bmp) {
//        int w = bmp.getWidth();
//        int h = bmp.getHeight();
//        int rgb = 0;
//        int[][] imgBin = new int[w][h];
//
//        for (int i = 0; i < w; i++) {
//            for (int j = 0; j < h; j++) {
//                rgb = bmp.getPixel(i, j);
//                imgBin[i][j] = rgb != 0 ? 1 : 0;
//            }
//        }
//        return imgBin;
//    }

    public static int[][] fTranslacao(int img[][], int dx, int dy) {
        int w = img.length;
        int h = img[0].length;

        int imgTMP[][] = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                imgTMP[i][j] = img[i + dx][j + dy];
            }
        }
        return imgTMP;
    }

    public ImageIcon redimensionar(BufferedImage image, int width, int heigh) throws IOException {
        try {
            BufferedImage new_img = new BufferedImage(width, heigh, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = new_img.createGraphics();
            g.drawImage(image, 0, 0, width, heigh, null);
            g.dispose();

            return new ImageIcon(new_img);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
