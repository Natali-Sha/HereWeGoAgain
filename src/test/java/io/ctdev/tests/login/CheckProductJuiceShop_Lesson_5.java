package io.ctdev.tests.login;

import io.ctdev.framework.config.TestConfig;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.model.Customer_hw6;
import io.ctdev.framework.pages.login_HW6.CheckProductFluent_Lesson_6;
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

public class CheckProductJuiceShop_Lesson_5 {

//    private String userName = "natali6@ukr.net";
//    private String pass = "09876543216";

    private Customer_hw6 testData;
    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private CheckProductFluent_Lesson_6 product;


    @BeforeClass
    public void login() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        getDriver().get(TestConfig.cfg.baseUrl());
        getDriver().navigate().refresh();
        WebElement wantMeIn = getDriver().findElement(By.xpath(".//*[@aria-label='dismiss cookie message']"));
        wait.until(ExpectedConditions.visibilityOf(wantMeIn));
        wantMeIn.click();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class*='close-dialog']")));
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();

        testData = Customer_hw6.newBuilder().withName("vik123@ukr.net").withPassword("12345678").withAnswer("00.00.0000").build();
        product = new CheckProductFluent_Lesson_6(driver);
    }

//        getDriver().get("http://3.18.213.48/#/");
//        getDriver().navigate().refresh();
//        WebElement wantMeIn = getDriver().findElement(By.xpath(".//*[@aria-label='dismiss cookie message']"));
//        wait.until(ExpectedConditions.visibilityOf(wantMeIn));
//        wantMeIn.click();
//
//        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();
//
//        WebElement element = getDriver().findElement(By.id("navbarAccount"));
//        element.click();
//
//        getDriver().findElement(By.id("navbarLoginButton")).click();
//
//        getDriver().findElement(By.id("email")).sendKeys(userName);
//
//        getDriver().findElement(By.id("password")).sendKeys(pass);
//
//        getDriver().findElement(By.id("loginButton")).click();
//    }

    @AfterClass
    public void closeWebDriver() {
        WebDriverSingleton.closeDriver();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().navigate().refresh();
    }

    @Test
    public void verifiesActualInformationAboutProduct(){

        WebElement banana = product.clickOnAccountButton().clickOnLoginButtonAfterAcc().
                enterUserEmail_hw6(testData.getEmail()).enterUserPassword_hw6(testData.getPassword()).
                clickOnLoginButton().bananaProduct().checkBananaProduct();

        Assert.assertEquals(banana.findElement(By.xpath(".//h1")).getText(), "Banana Juice (1000ml)", "\"Banana Juice (1000ml)\"- The title is invalid.");
        Assert.assertEquals(banana.findElement(By.xpath(".//div")).getText(), "Monkeys love it the most.", "\"Monkeys love it the most.\"- The description is invalid.");
//
//      Assert.assertEquals( banana.findElement(By.xpath(".//*[@class='item-price']")).getText(),"1.99¤");
        Assert.assertEquals(banana.findElement(By.xpath(".//div/p")).getText(), "1.99¤", "\"1.99¤\"- The price is invalid.");

        //        getDriver().findElement(By.xpath(".//*[@class='item-name'][contains(., 'Banana')]")).click();
//        WebElement banana = getDriver().findElement(By.xpath(".//*[h1 and contains(., 'Banana Juice (1000ml)')]"));


    }

    @Test
    public void addingProductToBasketPopUp() {

//

        String bananaBasketStr = product.findBananaForUse().bananaBasketPopup();
        System.out.println(bananaBasketStr);
        Assert.assertEquals(bananaBasketStr, "Placed Banana Juice (1000ml) into basket.", "Pop-up is not shown");
        getDriver().findElement(By.xpath(".//mat-card[contains(., 'Banana')]/div/button")).click();
//
//        WebElement bananaBasketPopup = getDriver().findElement(By.xpath(".//snack-bar-container/simple-snack-bar/span"));
//
//        wait.until(ExpectedConditions.visibilityOf(bananaBasketPopup));
//        String bananaBasketStr = bananaBasketPopup.getText();
    }

    @Test
    public void addingProductToBasket(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

       int bananaInBasket =  product.findBananaForUse().openABasket().bananaInTheBasked();

//        getDriver().findElement(By.xpath(".//mat-card[contains(., 'Banana')]/div/button")).click();
//        WebElement bananaBasketPopup = getDriver().findElement(By.xpath(".//snack-bar-container/simple-snack-bar/span"));
//
//        wait.until(ExpectedConditions.visibilityOf(bananaBasketPopup));
//        getDriver().findElement(By.xpath(".//*[@class='mat-focus-indicator buttons mat-button mat-button-base ng-star-inserted']")).click();
//        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(".//mat-table/mat-row/mat-cell[contains(., 'Banana')]"))));

//        int bananaInBasket = getDriver().findElements(By.xpath(".//mat-table/mat-row/mat-cell[contains(., 'Banana')]")).size();
        Assert.assertTrue(bananaInBasket > 0, "Not edit to basket");
    }

    @Test
    public void soldOutProduct(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        String outOfStockPopupStr =  product.nextPage().owaspProduct().owaspProductInBasket();
        System.out.println(outOfStockPopupStr);
        Assert.assertEquals(outOfStockPopupStr, "We are out of stock! Sorry for the inconvenience.", "Pop-up is not shown");


//        WebElement nextPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@aria-label='Next page']")));
//
//        //  WebElement nextPage = getDriver().findElement(By.xpath(".//*[@aria-label='Next page']"));
//
////        Actions actions = new Actions(getDriver());
////        actions.moveToElement(nextPage);
//
//        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", nextPage);
//
//        nextPage.click();
//
//
//        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(".//mat-card[contains(., 'OWASP Juice Shop Coaster')]/div/button"))));
//
//        WebElement owasp = getDriver().findElement(By.xpath(".//mat-card[contains(., 'OWASP Juice Shop Coaster')]/div/button"));
//        owasp.click();
//        WebElement outOfStockPopup = getDriver().findElement(By.xpath(".//snack-bar-container/simple-snack-bar/span"));
//
//        wait.until(ExpectedConditions.visibilityOf(outOfStockPopup));
//        String outOfStockPopupStr = outOfStockPopup.getText();


    }

}