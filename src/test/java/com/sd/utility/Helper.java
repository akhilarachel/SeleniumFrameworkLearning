package com.sd.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    public static String getScreenshot(WebDriver driver){
        String screenshotLocation = System.getProperty("user.dir")+"/Screenshots/picture_"+getRandomValue()+".png";
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(screenshotLocation));
        }catch (Exception e){
            System.out.println("Screenshot can't be captured: "+e.getMessage());
        }
        return screenshotLocation;
    }

    public static String getRandomValue(){
        DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date randomValue = new Date();
        return customFormat.format(randomValue);
    }
}
