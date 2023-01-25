package com.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class finishCheckout {
    WebDriver driver;

    public finishCheckout(WebDriver pDriver){
        this.driver = pDriver;
    }

    @FindBy(id = "finish") WebElement complete;
    //Complete purchase
    public void confirmBuy(){
        complete.click();
    }
}
