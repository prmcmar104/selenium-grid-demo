package com.grid.demo.testsuite;

import com.grid.demo.testbase.TestBase;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
public class GridDemoParallelTest extends TestBase {


    @Test
    public void testOne() {
        System.out.println("Page title is: " + driver.getTitle());
    }

}
