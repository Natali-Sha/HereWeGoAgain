package io.ctdev;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

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

        driver.get("https://www.google.com.ua");

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Thread.sleep(5000);
        Assert.assertEquals(actualTitle,expectedTitle, "Tab tittle is not equal");

        driver.quit();
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("This is before class");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This is after class");
        driver.quit();
    }

    // @BeforeClass
   // public void setupClass() {
    //    WebDriverManager.chromedriver().setup();

    }

//}
