package com.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkout {
    WebDriver driver;

    public checkout(WebDriver chDriver){
        this.driver = chDriver;
    }

    @FindBy(id = "checkout") WebElement checkout;
    @FindBy(id = "first-name") WebElement firstNameApp;
    @FindBy(id = "last-name") WebElement lastNameApp;
    @FindBy(id = "postal-code") WebElement zipCodeApp;

    //Entering details for check out
    public void checkout(String firstName, String lastName, String zipCode){
        checkout.click();
        firstNameApp.sendKeys(firstName);
        lastNameApp.sendKeys(lastName);
        zipCodeApp.sendKeys(zipCode);
    }
}
