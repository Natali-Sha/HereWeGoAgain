package io.ctdev.tests.login;

import io.ctdev.framework.config.TestConfig;
import io.ctdev.framework.model.CustomerHw6;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.pages.login_HW6.LoginFluentLesson6;
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

public class NegativeTestsForLoginLesson4 {

    private CustomerHw6 customerLogin;
    private CustomerHw6 customerInvalidLogin;

    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private LoginFluentLesson6 fluentPage_hw6;


    @BeforeClass
    public void SetUp() {

//        getDriver().get("http://3.18.213.48/#/");
        getDriver().get(TestConfig.cfg.baseUrl());

        fluentPage_hw6 = new LoginFluentLesson6(driver);

        wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='close-dialog']")));
        fluentPage_hw6.closeDialogLogin();

        customerLogin = CustomerHw6.newBuilder().withName("natali6@ukr.net").withPassword("09876543216").build();
        customerInvalidLogin = CustomerHw6.newBuilder().withInvalidUsername("natali6ukr.net").withInvalidPass("123456789").build();

    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

    @AfterMethod
    public void clearData() {

        fluentPage_hw6.clearDataEmail();
        fluentPage_hw6.clearDataPassword();
        getDriver().navigate().refresh();
    }

    @Test
    public void notPossibleToLoginWithoutEmail() {
        fluentPage_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().
                enterUserPassword_hw6(customerLogin.getEmail());

        fluentPage_hw6.findLoginButtonAttribute();

        Assert.assertEquals(fluentPage_hw6.findLoginButtonAttribute(), "true", "Login button is enabled w/o user email.");

    }

    @Test
    public void notPossibleToLoginWithoutPass() {

        fluentPage_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().
                enterUserEmail_hw6(customerLogin.getEmail());

        fluentPage_hw6.findLoginButtonAttribute();
        Assert.assertEquals(fluentPage_hw6.findLoginButtonAttribute(), "true", "Login button is enabled w/o user email.");

    }

    @Test
    public void notPossibleToLoginWithInvalidPass() {

        fluentPage_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().
                enterUserEmail_hw6(customerLogin.getEmail()).enterUserPassword_hw6(customerInvalidLogin.getInvalidPass()).
                submitLoginForUser_hw6();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")));

        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")).size() > 0, "Warning massage 'Invalid email or password.' is not shown");

    }


    @Test
    public void notPossibleToLoginWithInvalidEmail() {

        fluentPage_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().
                enterUserEmail_hw6(customerLogin.getEmail()).enterUserPassword_hw6(customerInvalidLogin.getInvalidUserName()).
                submitLoginForUser_hw6();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")));

        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")).size() > 0, "Warning massage 'Invalid email or password.' is not shown");
    }

}