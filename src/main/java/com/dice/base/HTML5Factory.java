package com.dice.base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class HTML5Factory extends BaseTest{

    //how can be used with <canvas>
    public void canvasDrawing() throws Exception {
        //Get the HTML5 Canvas Element
        WebElement canvas = driver.findElement(By.id("imageTemp"));

        //Select the Pencil Tool
        Select drawtool = new Select(driver.findElement(By.id("dtool")));
        drawtool.selectByValue("pencil");

        //Create a Action Chain for Draw a shape on Canvas
        Actions builder = new Actions(driver);
        builder.clickAndHold(canvas).moveByOffset(10, 50).
                moveByOffset(50,10).
                moveByOffset(-10,-50).
                moveByOffset(-50,-10).release().perform();

        //Get a screenshot of Canvas element after Drawing and
        //compare it to the base version to verify if the Drawing is performed
        FileUtils.copyFile(ScreenshotFactory.captureElementBitmap(driver, canvas), new File("c:\\tmp\\post.png"));
        assertEquals(CompareUtil.Result.Matched, CompareUtil.CompareImage("c:\\tmp\\base_post.png", "c:\\tmp\\post.png"));
    }

    //how can be used with <video>
    public void videoPlayer() throws Exception {
        File scrFile = null;

        //Get the HTML5 Video Element
        WebElement videoPlayer = driver.findElement(By.id("vplayer"));

        //We will need a JavaScript Executor for interacting
        //with Video Element's
        //methods and properties for automation
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Get the Source of Video that will be played in Video Player
        String source = (String) jsExecutor.executeScript("return arguments[0].currentSrc;", videoPlayer);

        //Get the Duration of Video
        long duration = (Long) jsExecutor.executeScript("return arguments[0].duration", videoPlayer);
        System.out.println(duration);

        //Verify Correct Video is loaded and duration
        assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
        assertEquals(25, duration);

        //Play the Video
        jsExecutor.executeScript("return arguments[0].play()", videoPlayer);
        Thread.sleep(5000);//bad practise

        //Pause the video
        jsExecutor.executeScript("arguments[0].pause()", videoPlayer);

        //Take a screen-shot for later verification
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\pause_play.png"));
    }

    //Web Storage
    public void localStorage() throws Exception {
        String lastName;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Get the current value of localStorage.lastname, this should be Smith
        lastName = (String) jsExecutor.executeScript("return localStorage.lastname;");
        assertEquals("Smith", lastName);
    }

}
