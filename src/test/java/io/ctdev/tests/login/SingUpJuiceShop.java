package io.ctdev.tests.login;

import io.ctdev.framework.config.TestConfig;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.model.CustomerHw6;
import io.ctdev.framework.pages.singUpPageObject.SingUpPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class SingUpJuiceShop {

    private CustomerHw6 singUp;
    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private SingUpPageObject fluentPageRegister_hw6;
    private SingUpPageObject uniqueLoginName;

    @BeforeClass
    public void beforeSingUp() {

        getDriver().get(TestConfig.cfg.baseUrl());
        getDriver().navigate().refresh();

        fluentPageRegister_hw6 = new SingUpPageObject(driver);
        wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class*='close-dialog']")));
        fluentPageRegister_hw6.closeDialog();
        singUp = CustomerHw6.newBuilder().withPass("09876543217").withAnswer("00.00.0000").build();

    }

    @AfterClass
    public void tearDown() {

        WebDriverSingleton.closeDriver();
    }

    @Test
    public void userIsAbleSingUpToShop() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 7);

        fluentPageRegister_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().
                notYetCustomer_hw6().uniqueLoginName().switchToggle_hw6().inputUserPass(singUp.getPass()).
                repeatUserPass(singUp.getPass()).securityQuestion().selectSecurityQuestion().
                securityAnswer(singUp.getAnswer()).registerButton();

        wait.until(ExpectedConditions.urlToBe("http://3.18.213.48/#/login"));
        String getCurrentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(getCurrentUrl, "http://3.18.213.48/#/login", "Registration error");


    }
}