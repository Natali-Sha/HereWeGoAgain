package io.ctdev.tests.login;


import io.ctdev.tests.BaseTest;
import io.ctdev.tests.framework.driver.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static io.ctdev.tests.framework.driver.WebDriverSingleton.getDriver;

public class Random_Lesson_2 extends BaseTest {
    /**
     * Unit test for simple App.
     */

    WebDriver driver;

    //WebDriver driver = new ChromeDriver();

    @Test
    public void shouldAnswerWithTrue2() throws InterruptedException {


        driver.get("https://www.rozetka.com.ua");

        String expectedTitle = "Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине";
        String actualTitle = driver.getTitle();

        Thread.sleep(3000);
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
//
        driver = getDriver();
    }

    @AfterClass
    public void afterClass() {

        WebDriverSingleton.closeDriver();

    }
}
