package com.sd.tests;

import com.sd.pages.*;
import com.sd.utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1CheckoutForStandardUser extends launcherClass {
    double totalPriceActual, totalPriceExpected;

    //Login
    @Test(priority = 1)
    public void loginApp(){
        logger = report.createTest("Login to CRM");
        login li = PageFactory.initElements(driver,login.class);
        logger.info("Launched the URL");
        li.login(exReader.getStringData("Login", 0, 0), exReader.getStringData("Login", 0, 1));
        logger.pass("Logged in successfully");
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Products')]")).isDisplayed());
    }

    //Product details page and adding products to the cart
    @Test(priority = 2)
    public void productPriceCheck(){
        logger = report.createTest("Fetching price of a product");
        addProducts pd = PageFactory.initElements(driver, addProducts.class);
        totalPriceExpected = pd.productPrice();
        pd.addToCart();
        Integer number = Integer.parseInt(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText());
        logger.pass("Products added successfully");
        Assert.assertEquals(number,2);
    }

    //Checking cart
    @Test(priority = 3)
    public void goToCart(){
        logger = report.createTest("Checking cart");
        cart c = PageFactory.initElements(driver, cart.class);
        c.goToCart();
        logger.pass("2 products present in cart");
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed());
    }

    //Entering checkout details
    @Test(priority = 4)
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

    //Price comparison
    @Test(priority = 5)
    public void priceComparison(){
        logger = report.createTest("Price comparison in the final page");
        checkoutOverview cf = PageFactory.initElements(driver, checkoutOverview.class);
        cf.finalCheckout();
        totalPriceActual = cf.totalPriceCheck();
        logger.pass("Price matched");
        Assert.assertEquals(totalPriceActual, totalPriceExpected);
    }

    //Finishing the purchase
    @Test(priority = 6)
    public void completeCheckout(){
        logger = report.createTest("Complete purchase");
        finishCheckout fs = PageFactory.initElements(driver, finishCheckout.class);
        fs.confirmBuy();
        logger.pass("Purchase is successful");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")).isDisplayed());
    }

    //Logout
    @Test(priority = 7)
    public void logoutApp(){
        logger = report.createTest("Logging out");
        logout lo = PageFactory.initElements(driver, logout.class);
        lo.logout();
        logger.pass("Logged out successfully");
        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
    }
}
