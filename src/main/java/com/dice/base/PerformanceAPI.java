package com.dice.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

//window.performance.timing.navigationStart
//window.performance.timing.requestStart
//window.performance.timing.responseStart
//window.performance.timing.responseEnd
//window.performance.timing.domLoading
//window.performance.timing.domComplete
//window.performance.timing.loadEventStart
//window.performance.timing.loadEventEnd
//end more
public class PerformanceAPI {

    public void getTimeLoadPage (WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Get time Load Event End (End of load page)
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        // Get Navigation Event Start (Start load data)
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        // Difference Load Event End and Navigation Event Start - time for loading page
        System.out.println("Page Load Time is " + (loadEventEnd - navigationStart)/1000 + " seconds.");
    }


}
