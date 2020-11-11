package io.ctdev.tests.login;

import io.ctdev.framework.config.TestConfig;
import io.ctdev.framework.model.CustomerHw6;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.pages.loginPageObject.LoginPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class NegativeTestsForLoginJuiceShop {

    private CustomerHw6 customerLogin;
    private CustomerHw6 customerInvalidLogin;
    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private LoginPageObject loginPageObject;


    @BeforeClass
    public void SetUp() {

        getDriver().get(TestConfig.cfg.baseUrl());

        loginPageObject = new LoginPageObject(driver);

        wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='close-dialog']")));
        loginPageObject.clickForClosePopUpOnMainPage();

        customerLogin = CustomerHw6.newBuilder().withName("natali6@ukr.net").withPassword("09876543216").build();
        customerInvalidLogin = CustomerHw6.newBuilder().withInvalidUsername("natali6ukr.net").withInvalidPass("123456789").build();

    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

    @AfterMethod
    public void clearData() {

        loginPageObject.clearEmailFieldOnLoginPage();
        loginPageObject.clearPasswordFieldOnLoginPage();
        getDriver().navigate().refresh();
    }

    @Test
    public void notPossibleToLoginWithoutEmail() {
        loginPageObject.clickOnAccountButtonOnMainPage().clickOnLoginButtonOnMainPage().
                enterUserPasswordOnLoginPage(customerLogin.getEmail());

        loginPageObject.findLoginButtonAttribute();

        Assert.assertEquals(loginPageObject.findLoginButtonAttribute(), "true", "Login button is enabled w/o user email.");

    }

    @Test
    public void notPossibleToLoginWithoutPass() {

        loginPageObject.clickOnAccountButtonOnMainPage().clickOnLoginButtonOnMainPage().
                enterUserEmailPasswordOnLoginPage(customerLogin.getEmail());

        loginPageObject.findLoginButtonAttribute();
        Assert.assertEquals(loginPageObject.findLoginButtonAttribute(), "true", "Login button is enabled w/o user email.");

    }

    @Test
    public void notPossibleToLoginWithInvalidPass() {

        loginPageObject.clickOnAccountButtonOnMainPage().clickOnLoginButtonOnMainPage().
                enterUserEmailPasswordOnLoginPage(customerLogin.getEmail()).enterUserPasswordOnLoginPage(customerInvalidLogin.getInvalidPass()).
                submitLoginForUser();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")));

        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")).size() > 0, "Warning massage 'Invalid email or password.' is not shown");

    }


    @Test
    public void notPossibleToLoginWithInvalidEmail() {

        loginPageObject.clickOnAccountButtonOnMainPage().clickOnLoginButtonOnMainPage().
                enterUserEmailPasswordOnLoginPage(customerLogin.getEmail()).enterUserPasswordOnLoginPage(customerInvalidLogin.getInvalidUserName()).
                submitLoginForUser();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")));

        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")).size() > 0, "Warning massage 'Invalid email or password.' is not shown");
    }

}