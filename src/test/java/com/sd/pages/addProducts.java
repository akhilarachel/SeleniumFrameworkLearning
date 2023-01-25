package com.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addProducts {
    WebDriver driver;
    Double priceOfFirstItem;
    Double priceOfSecondItem;

    public addProducts (WebDriver pDriver){
        this.driver = pDriver;
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")
    WebElement price1;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]")
    WebElement price2;
    @FindBy(id = "add-to-cart-sauce-labs-backpack") WebElement addProduct1;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light") WebElement addProduct2;

    //Fetching individual prices of each item
    public double productPrice(){
        priceOfFirstItem = Double.parseDouble(price1.getText().substring(1));
        priceOfSecondItem = Double.parseDouble(price2.getText().substring(1));
        return priceOfFirstItem + priceOfSecondItem;
    }

    //Adding products to the cart
    public void addToCart(){
        addProduct1.click();
        addProduct2.click();
    }
}
