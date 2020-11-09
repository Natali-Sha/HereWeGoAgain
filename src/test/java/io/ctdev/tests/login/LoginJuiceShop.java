package io.ctdev.tests.login;

import io.ctdev.framework.config.TestConfig;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.model.CustomerHw6;

import io.ctdev.framework.pages.loginPageObject.LoginPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class LoginJuiceShop {


    private CustomerHw6 customerLogin;
    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private LoginPageObject loginPageObject;


    @BeforeClass
    public void setUp() {

        getDriver().get(TestConfig.cfg.baseUrl());

        wait = new WebDriverWait(driver, 5);
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();
        customerLogin = CustomerHw6.newBuilder().withName("natali6@ukr.net").withPassword("09876543216").build();
        loginPageObject = new LoginPageObject(driver);

    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

    @Test
    public void userIsAbleToLogin() {

        String loggedInUser = loginPageObject.clickOnAccountButtonOnMainPage().clickOnLoginButtonOnMainPage().enterUserEmailPasswordOnLoginPage(customerLogin.getEmail()).
                enterUserPasswordOnLoginPage(customerLogin.getPassword()).
                submitLoginForUser().getCurrentLoggedUserName();

        Assert.assertEquals(loggedInUser, customerLogin.getEmail(), "User name does not mach");

    }


}





