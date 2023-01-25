package com.sd.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSettings {
    public WebDriver driver;

    //Selecting the browser according to the input
    public WebDriver openBrowser (String browserName, String appURL) {
        if(browserName.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("FireFox")){
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.get(appURL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public void quitBrowser (WebDriver driver) {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
