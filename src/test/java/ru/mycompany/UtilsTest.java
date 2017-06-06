package test.java.ru.mycompany;

import org.testng.annotations.Test;
import main.java.ru.mycompany.utils.ImageSizeChanger;

import java.awt.*;
import java.io.IOException;

import static org.testng.Assert.*;

/**
 * Created by nick on 05.06.17.
 */
public class UtilsTest {

    @Test(description = "проверка правильности масштабирования фотографий")
    public void scaleImageTest() throws IOException {
        ImageSizeChanger imageSizeChanger = new ImageSizeChanger();
        Image changedImage = imageSizeChanger.changeImageSize("/home/nick/Изображения/уир/Т-все/Class-2-P18(2)-1-2-.bmp");
        int widht =  changedImage.getWidth((img, infoflags, x, y, width, height) -> false);
        int height = changedImage.getHeight((img, infoflags, x, y, width, height1)-> false);

        assertEquals(widht,128);
        assertEquals(height,128);
    }
}
