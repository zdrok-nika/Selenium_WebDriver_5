package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Установка и настройка WebDriver
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.edgedriver().setup();
    }

    @Test
    public void fillFormAndSubmit() {
        // Запуск Chrome
        driver = new ChromeDriver();
        testForm(driver);

//        // Запуск Firefox
//        driver = new FirefoxDriver();
//        testForm(driver);
//
//        // Запуск Edge
//        driver = new EdgeDriver();
//        testForm(driver);
    }

    private void testForm(WebDriver driver) {
        // Переход на страницу
        driver.get("https://demoqa.com/automation-practice-form");

        // Заполнение полей
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("userEmail")).sendKeys("johndoe@example.com");
        driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.cssSelector(".react-datepicker__month-select")).sendKeys("January");
        driver.findElement(By.cssSelector(".react-datepicker__year-select")).sendKeys("1990");
        driver.findElement(By.cssSelector(".react-datepicker__day--001")).click();
        driver.findElement(By.id("subjectsInput")).sendKeys("Maths");
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("123 Street, City, Country");

        // Нажатие кнопки Submit
        driver.findElement(By.id("submit")).click();

        // Ожидание появления окна с данными
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));

        // Проверка правильности заполнения данных
        String name = driver.findElement(By.cssSelector(".table-responsive tbody tr:nth-child(1) td:nth-child(2)")).getText();
        String email = driver.findElement(By.cssSelector(".table-responsive tbody tr:nth-child(2) td:nth-child(2)")).getText();
        String gender = driver.findElement(By.cssSelector(".table-responsive tbody tr:nth-child(3) td:nth-child(2)")).getText();
        String mobile = driver.findElement(By.cssSelector(".table-responsive tbody tr:nth-child(4) td:nth-child(2)")).getText();
        String dob = driver.findElement(By.cssSelector(".table-responsive tbody tr:nth-child(5) td:nth-child(2)")).getText();
        String subjects = driver.findElement(By.cssSelector(".table-responsive tbody tr:nth-child(6) td:nth-child(2)")).getText();
        String hobbies = driver.findElement(By.cssSelector(".table-responsive tbody tr:nth-child(7) td:nth-child(2)")).getText();
        String address = driver.findElement(By.cssSelector(".table-responsive tbody tr:nth-child(9) td:nth-child(2)")).getText();

        assert name.equals("John Doe");
        assert email.equals("johndoe@example.com");
        assert gender.equals("Male");
        assert mobile.equals("1234567890");
        assert dob.equals("01 January,1990");
        assert subjects.equals("Maths");
        assert hobbies.equals("Sports");
        assert address.equals("123 Street, City, Country");
    }

    @After
    public void tearDown() {
        // Закрытие браузера
        if (driver != null) {
            driver.quit();
        }
    }
}

