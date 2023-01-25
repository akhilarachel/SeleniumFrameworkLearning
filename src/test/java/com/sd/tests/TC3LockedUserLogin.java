package com.sd.tests;

import com.sd.pages.launcherClass;
import com.sd.pages.login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3LockedUserLogin extends launcherClass {
    //Test case for locked user
    @Test(priority = 1)
    public void loginApp(){
        logger = report.createTest("Login to CRM");
        login li = PageFactory.initElements(driver,login.class);
        logger.info("Launched the URL");
        li.login(exReader.getStringData("Login", 1, 0), exReader.getStringData("Login", 1, 1));
        logger.pass("Error message displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed());
    }
}
