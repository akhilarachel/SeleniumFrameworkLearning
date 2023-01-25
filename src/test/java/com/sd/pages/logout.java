package com.sd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class logout {
    WebDriver driver;
    public logout (WebDriver loDriver){
        this.driver = loDriver;
    }

    @FindBy(id = "react-burger-menu-btn") WebElement allMenu;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']") WebElement logoutButton;

    public void logout(){
        allMenu.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='logout_sidebar_link']"))).isDisplayed();
        logoutButton.click();
    }
}
