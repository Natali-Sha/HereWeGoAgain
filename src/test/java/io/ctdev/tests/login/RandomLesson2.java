package io.ctdev.tests.login;


import io.ctdev.framework.config.TestConfig;
import io.ctdev.tests.BaseTest;
import io.ctdev.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.Random;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class RandomLesson2 extends BaseTest {
    /**
     * Unit test for simple App.
     */

    WebDriver driver;

    @Test
    public void shouldAnswerWithTrue2() {

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        driver.get("https://www.rozetka.com.ua");

        String expectedTitle = "Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине";
        String actualTitle = driver.getTitle();

        wait.until(ExpectedConditions.titleContains("ROZETKA"));
        Assert.assertEquals(actualTitle, expectedTitle, "Tab tittle is not equal");

        driver.quit();
    }

    @Test
    public void randomRange() {

        Random rand = new Random();
        int randInt = rand.nextInt(10);
        System.out.println(randInt + " - value");
        Assert.assertTrue(1 <= randInt && randInt <= 10, "Integer in correct range");

    }

    @BeforeClass
    public void beforeClass() {
        driver = getDriver();
    }

    @AfterClass
    public void afterClass() {

        WebDriverSingleton.closeDriver();

    }
}
