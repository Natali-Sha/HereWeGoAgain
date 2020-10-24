package io.ctdev.tests.login;


import io.ctdev.tests.BaseTest;
import io.ctdev.tests.framework.driver.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.ctdev.tests.framework.driver.WebDriverSingleton;

import static io.ctdev.tests.framework.driver.WebDriverSingleton.getDriver;
import static org.testng.Assert.assertTrue;

import io.ctdev.tests.framework.config.TestConfig;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class MyFirstTest extends BaseTest {

    WebDriver driver;
    //WebDriver driver = new ChromeDriver();

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nataliia.shakhova\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        //   System.out.println("before");
        //  System.out.println("after");
        // driver.get("https://www.rozetka.com.ua");

        System.out.println(driver);
        driver.get("https://www.google.com.ua");

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Thread.sleep(5000);
        Assert.assertEquals(actualTitle, expectedTitle, "Tab tittle is not equal");

//        driver.quit();
    }


    @Test
    public void searchWebElement() throws InterruptedException {
        driver.get("https://www.google.com.ua");
        List<WebElement> elements = driver.findElements(By.tagName("div"));
        System.out.println(elements.size());

//        WebElement element = driver.findElement(By.name("q"));
//        element.sendKeys("Customertimes");
//        Thread.sleep(1500);

    }


    @BeforeClass
    public void beforeClass() {
//
//        WebDriverManager.chromedriver().setup();
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-fullscreen");
//
//        System.out.println("This is before class");
//        driver = new FirefoxDriver();
        driver = getDriver();
    }

    @AfterClass
    public void afterClass() {
        WebDriverSingleton.closeDriver();
    }
}
