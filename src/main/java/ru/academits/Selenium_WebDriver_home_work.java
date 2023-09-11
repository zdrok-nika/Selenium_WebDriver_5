package ru.academits;

import com.google.common.annotations.VisibleForTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_WebDriver_home_work {


//    @Test
//    public void loginTest() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("https://the-internet.herokuapp.com/");
//
//        Assert.assertEquals("https://the-internet.herokuapp.com/",
//        webDriver.getCurrentUrl());
//
//        webDriver.quit();
//    }

    @Test
    public void openDemoOATest() {
        WebDriver driver = null;

        String browserName = System.getProperty("browser");

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
// выдает ошибку : java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "browserName" is null
        String url = "https://demoqa.com/automation-practice-form";


    }
}
