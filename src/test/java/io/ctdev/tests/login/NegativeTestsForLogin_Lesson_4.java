package io.ctdev.tests.login;

import io.ctdev.tests.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.ctdev.tests.framework.driver.WebDriverSingleton.getDriver;

public class NegativeTestsForLogin_Lesson_4 {
    private String userName = "natali6@ukr.net";
    private String invalidUserName = "natali6ukr.net";
    private String invalidPass = "12345678900";
    private String pass = "09876543216";

    WebDriver driver = getDriver();

    WebDriverWait wait;

    @BeforeClass
    public void SetUp() {

        getDriver().get("http://3.18.213.48/#/");
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();
        wait = new WebDriverWait(driver, 5);

        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(By.id("navbarAccount"));
        element.click();

        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("navbarLoginButton")).click();
    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

    @AfterMethod
    public void clearData() {
        getDriver().findElement(By.id("email")).clear();
        getDriver().findElement(By.id("password")).clear();
    }

    @Test
    public void
    notPossibleToLoginWithoutEmail() throws InterruptedException {

        System.out.println("Typing user password");
        getDriver().findElement(By.id("password")).sendKeys(pass);

        System.out.println("Clicking on Login button");
        WebElement logButton = getDriver().findElement(By.id("loginButton"));
        String visible = logButton.getAttribute("disabled");

        Assert.assertEquals(visible, "true", "Login button is enabled w/o user email.");

        getDriver().navigate().refresh();
    }

    @Test
    public void notPossibleToLoginWithoutPass() throws InterruptedException {

        System.out.println("Typing user email - " + userName);
        getDriver().findElement(By.id("email")).sendKeys(userName);

        System.out.println("Clicking on Login button");
        WebElement logButton = getDriver().findElement(By.id("loginButton"));
        String visible = logButton.getAttribute("disabled");

        Assert.assertEquals(visible, "true", "Login button is enabled w/o user password.");

        getDriver().navigate().refresh();
    }

    @Test
    public void
    notPossibleToLoginWithInvalidPass() throws InterruptedException {

        System.out.println("Typing user email - " + userName);
        getDriver().findElement(By.id("email")).sendKeys(userName);

        System.out.println("Typing user password");
        getDriver().findElement(By.id("password")).sendKeys(invalidPass);

        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("loginButton")).click();

        Thread.sleep(3000);

        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")).size() > 0, "Warning massage 'Invalid email or password.' is not shown");

    }

    @Test
    public void notPossibleToLoginWithInvalidEmail() throws InterruptedException {

        System.out.println("Typing user email - " + invalidUserName);
        getDriver().findElement(By.id("email")).sendKeys(invalidUserName);

        System.out.println("Typing user password");
        getDriver().findElement(By.id("password")).sendKeys(pass);

        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("loginButton")).click();

        Thread.sleep(3000);

        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")).size() > 0, "Warning massage 'Invalid email or password.' is not shown");

    }

}