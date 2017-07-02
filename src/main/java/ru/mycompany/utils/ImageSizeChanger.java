package main.java.ru.mycompany.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/* Класс который который имеет функции для изменения размера фотографий */
public class ImageSizeChanger {

    private final int WIDTH = 128;  //размеры на которые меняем размер картинки
    private final int HEIGHT = 128; //размеры на которые меняем размер картинки

    public  Image changeImageSize(String path) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(path));
        return resizeImage(originalImage, WIDTH, HEIGHT);
    }

    /** Функция создает новое изображение с требуемыми размерами на основе исходного
     * @param image исходное изображение
     * @param width требуемая ширина
     * @param height требуемая высота
     * */
    private BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        return bufferedImage;
    }

    /*
     * @param directoryPath Функция менет размер всех ихзоражений из папки до 128*128 с сохранением отношений сторон
     *
     * @param targetDirectory И сохраняет полученные изображения в папку
     * */
    public void changeAllPhotoInDirectory(String directoryPath,String targetDirectory)  {
         File directory = new File(directoryPath);
         File[] files =  directory.listFiles();
         int num = 0;
         for (File file:files){
             try{
             BufferedImage originalImage = ImageIO.read(file);
             ImageIO.write(resizeImage(originalImage,128,128), "bmp", new File(targetDirectory +"/"+file.getName()));
             System.out.println("переписано изображение "+ num);
             num++;
             }catch(Exception e){
                 System.out.println("это не изображение");
             }
         }

    }
}
