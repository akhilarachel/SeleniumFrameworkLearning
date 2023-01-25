package com.sd.tests;

import com.sd.pages.*;
import com.sd.utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2EmptyCartCheckout extends launcherClass {
    @Test(priority = 1)
    public void loginApp(){
        logger = report.createTest("Login to CRM");
        login li = PageFactory.initElements(driver,login.class);
        logger.info("Launched the URL");
        li.login(exReader.getStringData("Login", 0, 0), exReader.getStringData("Login", 0, 1));
        logger.pass("Logged in successfully");
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Products')]")).isDisplayed());
    }

    //Checking empty cart
    @Test(priority = 2)
    public void goToCart(){
        logger = report.createTest("Checking cart");
        cart c = PageFactory.initElements(driver, cart.class);
        c.goToCart();
        logger.pass("Empty Cart");
        Assert.assertTrue(driver.findElement(By.id("checkout")).isDisplayed());
    }

    //Entering checkout details
    @Test(priority = 3)
    public void checkoutCart(){
        logger = report.createTest("Checking out process started");
        checkout co = PageFactory.initElements(driver, checkout.class);
        co.checkout(exReader.getStringData("Checkout",0,0),
                exReader.getStringData("Checkout",0,1),
                exReader.getStringData("Checkout",0,2));
        Helper.getScreenshot(driver);
        logger.pass("Checkout details added successfully");
        Assert.assertTrue(driver.findElement(By.id("continue")).isDisplayed());
    }

    //Finishing the purchase
    @Test(priority = 4)
    public void completeCheckout(){
        checkoutOverview cf = PageFactory.initElements(driver, checkoutOverview.class);
        cf.finalCheckout();
        logger = report.createTest("Complete purchase");
        finishCheckout fs = PageFactory.initElements(driver, finishCheckout.class);
        fs.confirmBuy();
        logger.pass("Purchase is successful");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")).isDisplayed());
    }

    //Logout
    @Test(priority = 5)
    public void logoutApp(){
        logger = report.createTest("Logging out");
        logout lo = PageFactory.initElements(driver, logout.class);
        lo.logout();
        logger.pass("Logged out successfully");
        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
    }
}
