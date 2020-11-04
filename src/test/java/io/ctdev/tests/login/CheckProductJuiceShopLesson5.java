package io.ctdev.tests.login;

import io.ctdev.framework.config.TestConfig;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.model.CustomerHw6;
import io.ctdev.framework.pages.login_HW6.CheckProductFluentLesson6;
import io.ctdev.framework.retry.DynamicRetryAnalyzer;
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

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class CheckProductJuiceShopLesson5 {

    private CustomerHw6 testData;
    private WebDriver driver = getDriver();
    private WebDriverWait wait = new WebDriverWait(getDriver(), 5);
    private CheckProductFluentLesson6 product = new CheckProductFluentLesson6(driver, wait);


    @BeforeClass
    public void login() {

        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(TestConfig.cfg.baseUrl());
        getDriver().get(TestConfig.cfg.baseUrl());
        getDriver().navigate().refresh();

        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(".//*[@aria-label='dismiss cookie message']")))).click();
        product.closeDialogProduct();
        testData = CustomerHw6.newBuilder().withName("vik123@ukr.net").withPassword("12345678").withAnswer("00.00.0000").build();

        product.clickOnAccountButton().clickOnLoginButtonAfterAcc().
                enterUserEmail_hw6(testData.getEmail()).enterUserPassword_hw6(testData.getPassword()).
                clickOnLoginButton();
    }

    @AfterClass
    public void closeWebDriver() {
        WebDriverSingleton.closeDriver();
    }


    @AfterMethod
    public void tearDown() {
        getDriver().navigate().refresh();
        product.clickOnMainLogoButton();

    }


    @Test
    public void soldOutProduct() {

        String outOfStockPopupStr = product.nextPage().owaspProduct().owaspProductInBasket();
        System.out.println(outOfStockPopupStr);
        Assert.assertEquals(outOfStockPopupStr, "We are out of stock! Sorry for the inconvenience.", "Pop-up is not shown");
    }

    @Test(retryAnalyzer = DynamicRetryAnalyzer.class, alwaysRun = true)
    public void verifiesActualInformationAboutProduct() {
        WebElement banana = product.addBananaProduct().checkBananaProduct();

        Assert.assertEquals(banana.findElement(By.xpath(".//h1")).getText(), "Banana Juice (1000ml)", "\"Banana Juice (1000ml)\"- The title is invalid.");
        Assert.assertEquals(banana.findElement(By.xpath(".//div")).getText(), "Monkeys love it the most.", "\"Monkeys love it the most.\"- The description is invalid.");
        Assert.assertEquals(banana.findElement(By.xpath(".//div/p")).getText(), "1.99¤", "\"1.99¤\"- The price is invalid.");

    }

    @Test(retryAnalyzer = DynamicRetryAnalyzer.class, alwaysRun = true)
    public void addingProductToBasketPopUp() {
//        wait.until(ExpectedConditions.urlToBe("http://3.18.213.48/#/search"));

        String bananaBasketStr = product.findBananaForUse().bananaBasketPopup();
        System.out.println(bananaBasketStr);
        Assert.assertEquals(bananaBasketStr, "Added another Banana Juice (1000ml) to basket.", "Pop-up is not shown");
        getDriver().findElement(By.xpath(".//mat-card[contains(., 'Banana')]/div/button")).click();
    }

    @Test
    public void addingProductToBasket() {

        int bananaInBasket = product.findBananaForUse().openABasket().bananaInTheBasked();
        Assert.assertTrue(bananaInBasket > 0, "Not edit to basket");

    }


}