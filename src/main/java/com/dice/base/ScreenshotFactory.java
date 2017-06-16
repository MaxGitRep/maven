package com.dice.base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;


public class ScreenshotFactory {

    public static File captureElementBitmap(WebDriver driver, WebElement element) throws Exception {
        // Делаем скриншот страницы
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Создаем экземпляр BufferedImage для работы с изображением
        BufferedImage img = ImageIO.read(screen);
        // Получаем размеры элемента
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        // Создаем прямоуголник (Rectangle) с размерами элемента
        Rectangle rect = new Rectangle(width, height);
        // Получаем координаты элемента
        Point p = element.getLocation();
        // Вырезаем изображенеи элемента из общего изображения
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        // Перезаписываем File screen
        ImageIO.write(dest, "png", screen);
        // Возвращаем File c изображением элемента
        return screen;
    }

    //how to use
    public void takeElementScreenshot(WebDriver driver, WebElement element) {
        //WebElement element = driver.findElement(By.id("element_id"));
        try {
            FileUtils.copyFile(captureElementBitmap(driver, element), new File("c:\\tmp\\div.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


