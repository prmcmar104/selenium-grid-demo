package com.grid.demo.browserfactory;

import com.grid.demo.propertyreader.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Created by Jay Vaghani
 */
public class ManageBrowser {
    public WebDriver driver;
    public String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    public String runOn = PropertyReader.getInstance().getProperty("runOn");
    public String gridUrl = PropertyReader.getInstance().getProperty("gridUrl");

    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions browserOptions = new ChromeOptions();
            if (runOn.equalsIgnoreCase("grid")) {
                System.out.println("#########TEST RUNNING ON GRID ==> On the Browser is " + browser);
                try {
                    driver = new RemoteWebDriver(new URL(gridUrl), browserOptions);
                } catch (MalformedURLException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("#########TEST RUNNING ON LOCAL ==> On the Browser is " + browser);
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions browserOptions = new FirefoxOptions();
            if (runOn.equalsIgnoreCase("grid")) {
                System.out.println("#########TEST RUNNING ON GRID ==> On the Browser is " + browser);
                try {
                    driver = new RemoteWebDriver(new URL(gridUrl), browserOptions);
                } catch (MalformedURLException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("#########TEST RUNNING ON LOCAL ==> On the Browser is " + browser);
                driver = new FirefoxDriver();
            }
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions browserOptions = new EdgeOptions();
            if (runOn.equalsIgnoreCase("grid")) {
                System.out.println("#########TEST RUNNING ON GRID ==> On the Browser is " + browser);
                try {
                    driver = new RemoteWebDriver(new URL(gridUrl), browserOptions);
                } catch (MalformedURLException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("#########TEST RUNNING ON LOCAL ==> On the Browser is " + browser);
                driver = new EdgeDriver();
            }
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertyReader.getInstance()
                .getProperty("implicitlyWait"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }
}
