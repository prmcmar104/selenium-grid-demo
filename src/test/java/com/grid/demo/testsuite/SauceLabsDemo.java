package com.grid.demo.testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by Jay
 */
public class SauceLabsDemo {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

    }

    @Test
    public void sauceLabTest() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        System.out.println("title of page is: " + driver.getTitle());
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
