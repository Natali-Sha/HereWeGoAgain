package io.ctdev.tests.login;

import io.ctdev.framework.config.TestConfig;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.model.CustomerHw6;

import io.ctdev.framework.pages.login_HW6.LoginFluentLesson6;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class TestLoginLesson4 {


    private CustomerHw6 customerLogin;
    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private LoginFluentLesson6 fluentPage_hw6;


    @BeforeClass
    public void setUp() {

        getDriver().get(TestConfig.cfg.baseUrl());

        wait = new WebDriverWait(driver, 5);
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();
        customerLogin = CustomerHw6.newBuilder().withName("natali6@ukr.net").withPassword("09876543216").build();
        fluentPage_hw6 = new LoginFluentLesson6(driver);

    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

    @Test
    public void userIsAbleToLogin() {

        String loggedInUser = fluentPage_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().enterUserEmail_hw6(customerLogin.getEmail()).
                enterUserPassword_hw6(customerLogin.getPassword()).
                submitLoginForUser_hw6().getCurrentLoggedUserName_hw6();

        Assert.assertEquals(loggedInUser, customerLogin.getEmail(), "User name does not mach");

    }


}





