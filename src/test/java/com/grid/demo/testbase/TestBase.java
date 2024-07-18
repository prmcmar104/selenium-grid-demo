package com.grid.demo.testbase;

import com.grid.demo.browserfactory.ManageBrowser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by Jay Vaghani
 */
public class TestBase extends ManageBrowser {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

}
