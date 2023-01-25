package com.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkoutOverview {
    WebDriver driver;
    double finalPriceWoTax;
    public checkoutOverview (WebDriver coDriver){
        this.driver = coDriver;
    }

    @FindBy(id = "continue") WebElement continueButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[5]")
    WebElement finalPriceDisplayed;

    public void finalCheckout(){
        continueButton.click();
    }
    //Total price and item total price display comparison
    public double totalPriceCheck(){
        finalPriceWoTax = Double.parseDouble(finalPriceDisplayed.getText().substring(13));
        return finalPriceWoTax;
    }
}
