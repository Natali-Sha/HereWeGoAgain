package io.ctdev.tests.login;

import io.ctdev.framework.config.TestConfig;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.model.Customer;
import io.ctdev.framework.model.Customer_hw6;

import io.ctdev.framework.pages.login_HW.LoginFluent_Lesson_6;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class TestLogin_Lesson_4 {

//    private String userName = "natali6@ukr.net";
//    private String pass = "09876543216";

    private Customer_hw6 customerLogin;
    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private LoginFluent_Lesson_6 fluentPage_hw6;

//    WebDriver driver = getDriver();
//    WebDriverWait wait;

    @BeforeClass
    public void setUp() {

//        getDriver().get("http://3.18.213.48/#/");
        getDriver().get(TestConfig.cfg.baseUrl());
        wait = new WebDriverWait(driver, 5);
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();
        customerLogin = Customer_hw6.newBuilder().withName("natali6@ukr.net").withPassword("09876543216").build();
        fluentPage_hw6 = new LoginFluent_Lesson_6(driver);

    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

    @Test
    public void userIsAbleToLogin() throws InterruptedException {

        String loggedInUser = fluentPage_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().enterUserEmail_hw6(customerLogin.getEmail()).
                enterUserPassword_hw6(customerLogin.getPassword()).
                submitLoginForUser_hw6().getCurrentLoggedUserName_hw6();

        Assert.assertEquals(loggedInUser, customerLogin.getEmail(), "User name does not mach");

//        System.out.println("Clicking on Account button");
//        WebElement element = getDriver().findElement(By.id("navbarAccount"));
//        element.click();
//
//        System.out.println("Clicking on Login button");
//        getDriver().findElement(By.id("navbarLoginButton")).click();
//
//        System.out.println("Typing user email - " + userName);
//        getDriver().findElement(By.id("email")).sendKeys(userName);
//
//        System.out.println("Typing user password");
//        getDriver().findElement(By.id("password")).sendKeys(pass);
//
//        System.out.println("Clicking on Login button");
//        getDriver().findElement(By.id("loginButton")).click();
//
//        getDriver().findElement(By.id("navbarAccount")).click();
//
//        WebElement userNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label='Go to user profile'] span")));
//        String actualUserName = loggedInUser.getAttribute("innerText").trim();
    }


}





