package com.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class login {
    WebDriver driver;
    public login(WebDriver appDriver){
        this.driver = appDriver;
    }

    @FindBy(id = "user-name") WebElement username;
    @FindBy(id = "password") WebElement password;
    @FindBy(id = "login-button") WebElement loginButton;

    public void login(String AppUsername, String AppPassword) {
        username.sendKeys(AppUsername);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        password.sendKeys(AppPassword);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginButton.click();
    }
}
