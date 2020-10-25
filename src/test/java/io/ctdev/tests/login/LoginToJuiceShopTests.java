package io.ctdev.tests.login;

import io.ctdev.tests.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.ctdev.tests.framework.driver.WebDriverSingleton.getDriver;

public class LoginToJuiceShopTests {

    private String userName = "dima@ukr.net";

    @BeforeClass
    public void SetUp() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().get("http://3.18.213.48/#/");
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();
    }
    @AfterClass
    public void tearDown(){
        WebDriverSingleton.closeDriver();
    }

    @Test
    public void userIsAbleToLoginToShop() throws InterruptedException {

        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(By.id("navbarAccount"));
        element.click();


        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("navbarLoginButton")).click();

        System.out.println("Typing user email - " + userName);
        getDriver().findElement(By.id("email")).sendKeys(userName);

        System.out.println("Typing user password - 12345678");
        getDriver().findElement(By.id("password")).sendKeys("12345678");

        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("loginButton")).click();

        getDriver().findElement(By.id("navbarAccount")).click();

        Thread.sleep(5000);

       String actualUserName = getDriver().findElement(By.cssSelector("[aria-label='Go to user profile'] span")).getAttribute("innerText").trim();

        Assert.assertEquals(actualUserName,userName, "User name does not mach");




    }


}
