package com.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cart {
    WebDriver driver;
    public cart(WebDriver cDriver){
        this.driver = cDriver;
    }

    @FindBy(id= "shopping_cart_container") WebElement cart;

    //Clicking on the basket logo on the top right corner of the page
    public void goToCart(){
        cart.click();
    }
}
