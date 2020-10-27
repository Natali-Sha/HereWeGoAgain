package io.ctdev.tests.login;

import io.ctdev.tests.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.ctdev.tests.framework.driver.WebDriverSingleton.getDriver;

public class TestLogin_Lesson_4 {

    private String userName = "natali6@ukr.net";
    private String pass = "09876543216";

    WebDriver driver = getDriver();

    WebDriverWait wait;

    @BeforeClass
    public void SetUp() {

        getDriver().get("http://3.18.213.48/#/");
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();
        wait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

    @Test
    public void userIsAbleToLogin() throws InterruptedException {

        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(By.id("navbarAccount"));
        element.click();

        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("navbarLoginButton")).click();

        System.out.println("Typing user email - " + userName);
        getDriver().findElement(By.id("email")).sendKeys(userName);

        System.out.println("Typing user password");
        getDriver().findElement(By.id("password")).sendKeys(pass);

        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("loginButton")).click();

        getDriver().findElement(By.id("navbarAccount")).click();

        WebElement userNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label='Go to user profile'] span")));

        String actualUserName = userNameElement.getAttribute("innerText").trim();

        Assert.assertEquals(actualUserName,  userName, "User name does not mach");


    }


}





