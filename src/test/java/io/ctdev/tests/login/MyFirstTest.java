package io.ctdev.tests.login;


import io.ctdev.tests.BaseTest;
import io.ctdev.framework.driver.WebDriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;
import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class MyFirstTest extends BaseTest {

    WebDriver driver;
    //WebDriver driver = new ChromeDriver();

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        System.out.println(driver);
        driver.get("https://www.google.com.ua");

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        wait.until(ExpectedConditions.titleContains("Go"));
        Assert.assertEquals(actualTitle, expectedTitle, "Tab tittle is not equal");

    }

    @Test
    public void searchWebElement() throws InterruptedException {
        driver.get("https://www.google.com.ua");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Customertimes");
        element.sendKeys(Keys.chord(Keys.ALT, "k"));

    }


    @BeforeClass
    public void beforeClass() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        driver = getDriver();
    }

    @AfterClass
    public void afterClass() {
        WebDriverSingleton.closeDriver();
    }
}
