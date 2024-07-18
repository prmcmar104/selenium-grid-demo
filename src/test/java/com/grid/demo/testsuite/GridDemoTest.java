package com.grid.demo.testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jay Vaghani
 */
public class GridDemoTest {
    @Test
    public void gridTest() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        driver.get("https://demo.nopcommerce.com/");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
