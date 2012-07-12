package com.mycompany.app;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Selenium2Example {

    @Test
    public void google() throws Exception {

        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://192.168.32.42:8080/audit/");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        WebElement FCMButton= driver.findElement(By.id("j_idt9:j_idt17"));
        FCMButton.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        WebElement ANFCButton = driver.findElement(By.id("j_idt24:j_idt25"));
        ANFCButton.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        WebElement FilterNameField = driver.findElement(By.id("filteringCriterion:filterName"));
        FilterNameField.sendKeys("AlexLITO");
        WebElement ExpressionField = driver.findElement(By.id("filteringCriterion:j_idt31"));
        ExpressionField.sendKeys("AlexLITO and Zebra");
        WebElement TestFilterXMLField = driver.findElement(By.id("filteringCriterion:testFilterXml"));
        TestFilterXMLField.sendKeys("123321");
        WebElement SaveButton = driver.findElement(By.id("filteringCriterion:j_idt36"));
        SaveButton.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();
    }


}