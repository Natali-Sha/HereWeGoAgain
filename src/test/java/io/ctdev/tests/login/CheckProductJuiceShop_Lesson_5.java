package io.ctdev.tests.login;

import io.ctdev.tests.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.ctdev.tests.framework.driver.WebDriverSingleton.getDriver;

public class CheckProductJuiceShop_Lesson_5 {

    private String userName = "natali6@ukr.net";
    private String pass = "09876543216";

    @BeforeClass
    public void login() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        getDriver().get("http://3.18.213.48/#/");
        getDriver().navigate().refresh();
        WebElement wantMeIn = getDriver().findElement(By.xpath(".//*[@aria-label='dismiss cookie message']"));
        wait.until(ExpectedConditions.visibilityOf(wantMeIn));
        wantMeIn.click();

        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();

        WebElement element = getDriver().findElement(By.id("navbarAccount"));
        element.click();

        getDriver().findElement(By.id("navbarLoginButton")).click();

        getDriver().findElement(By.id("email")).sendKeys(userName);

        getDriver().findElement(By.id("password")).sendKeys(pass);

        getDriver().findElement(By.id("loginButton")).click();
    }

    @AfterClass
    public void closeWebDriver() {
        WebDriverSingleton.closeDriver();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().navigate().refresh();
    }

    @Test
    public void verifiesActualInformationAboutProduct() throws InterruptedException {

        getDriver().findElement(By.xpath(".//*[@class='item-name'][contains(., 'Banana')]")).click();

        WebElement banana = getDriver().findElement(By.xpath(".//*[h1 and contains(., 'Banana Juice (1000ml)')]"));

        Assert.assertEquals(banana.findElement(By.xpath(".//h1")).getText(), "Banana Juice (1000ml)", "\"Banana Juice (1000ml)\"- The title is invalid.");
        Assert.assertEquals(banana.findElement(By.xpath(".//div")).getText(), "Monkeys love it the most.", "\"Monkeys love it the most.\"- The description is invalid.");
//
//      Assert.assertEquals( banana.findElement(By.xpath(".//*[@class='item-price']")).getText(),"1.99¤");
        Assert.assertEquals(banana.findElement(By.xpath(".//div/p")).getText(), "1.99¤", "\"1.99¤\"- The price is invalid.");
    }

    @Test
    public void addingProductToBasketPopUp() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        getDriver().findElement(By.xpath(".//mat-card[contains(., 'Banana')]/div/button")).click();

        WebElement bananaBasketPopup = getDriver().findElement(By.xpath(".//snack-bar-container/simple-snack-bar/span"));

        wait.until(ExpectedConditions.visibilityOf(bananaBasketPopup));
        String bananaBasketStr = bananaBasketPopup.getText();


        System.out.println(bananaBasketStr);
        Assert.assertEquals(bananaBasketStr, "Placed Banana Juice (1000ml) into basket.", "Pop-up is not shown");

    }

    @Test
    public void addingProductToBasket() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        getDriver().findElement(By.xpath(".//mat-card[contains(., 'Banana')]/div/button")).click();
        WebElement bananaBasketPopup = getDriver().findElement(By.xpath(".//snack-bar-container/simple-snack-bar/span"));

        wait.until(ExpectedConditions.visibilityOf(bananaBasketPopup));
        getDriver().findElement(By.xpath(".//*[@class='mat-focus-indicator buttons mat-button mat-button-base ng-star-inserted']")).click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(".//mat-table/mat-row/mat-cell[contains(., 'Banana')]"))));

        int bananaInBasket = getDriver().findElements(By.xpath(".//mat-table/mat-row/mat-cell[contains(., 'Banana')]")).size();
        Assert.assertTrue(bananaInBasket > 0, "Not edit to basket");
    }

    @Test
    public void soldOutProduct() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement nextPage = getDriver().findElement(By.xpath(".//*[@aria-label='Next page']"));

//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(nextPage);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", nextPage);
        Thread.sleep(500);

        wait.until(ExpectedConditions.visibilityOf(nextPage));
        nextPage.click();


        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(".//mat-card[contains(., 'OWASP Juice Shop Coaster')]/div/button"))));

        WebElement owasp = getDriver().findElement(By.xpath(".//mat-card[contains(., 'OWASP Juice Shop Coaster')]/div/button"));
        owasp.click();
        WebElement outOfStockPopup = getDriver().findElement(By.xpath(".//snack-bar-container/simple-snack-bar/span"));

        wait.until(ExpectedConditions.visibilityOf(outOfStockPopup));
        String outOfStockPopupStr = outOfStockPopup.getText();

        System.out.println(outOfStockPopupStr);
        Assert.assertEquals(outOfStockPopupStr, "We are out of stock! Sorry for the inconvenience.", "Pop-up is not shown");

    }

}