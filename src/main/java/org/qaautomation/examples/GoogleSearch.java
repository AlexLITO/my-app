package org.qaautomation.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Search Google example.
 *
 * @author Rahul
 */
public class GoogleSearch {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    public static void main(String[] args) {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://192.168.32.42:8080/audit/");

        WebElement FCMButton= driver.findElement(By.id("j_idt9:j_idt17"));
        FCMButton.click();
        driver.manage().timeouts().pageLoadTimeOut(90, TimeUnit.seconds);
        WebElement ANFCButton = driver.findElement(By.id("j_idt24:j_idt25"));
        ANFCButton.click();
        driver.manage().timeouts().pageLoadTimeOut(90, TimeUnit.seconds);
        WebElement FilterNameField = driver.findElement(By.id("filteringCriterion:filterName"));
        FilterNameField.sendKeys("AlexLITO");
        WebElement ExpressionField = driver.findElement(By.id("filteringCriterion:j_idt31"));
        ExpressionField.sendKeys("AlexLITO and Zebra");
        WebElement TestFilterXMLField = driver.findElement(By.id("filteringCriterion:testFilterXml"));
        TestFilterXMLField.sendKeys("123321");
        WebElement SaveButton = driver.findElement(By.id("filteringCriterion:j_idt36"));
        SaveButton.click();
        driver.manage().timeouts().pageLoadTimeOut(90, TimeUnit.seconds);







        boolean result;
        try {
            result = firstPageContainsQAANet();
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            driver.close();
        }

        System.out.println("Test " + (result? "passed." : "failed."));
        if (!result) {
            System.exit(1);
        }
    }

    private static boolean firstPageContainsQAANet() {
        //type search query
        driver.findElement(By.name("q")).sendKeys("qa automation\n");

        // click search
        driver.findElement(By.name("btnG")).click();

        // Wait for search to complete
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Searching ...");
                return webDriver.findElement(By.id("resultStats")) != null;
            }
        });

        // Look for QAAutomation.net in the results
        return driver.findElement(By.tagName("body")).getText().contains("qaautomation.net");
    }
}