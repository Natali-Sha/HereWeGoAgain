package io.ctdev.framework.pages.login_HW6;

import io.ctdev.framework.pages.AbstractPage;
import io.ctdev.tests.login.CheckProductJuiceShop_Lesson_5;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class CheckProductFluent_Lesson_6 extends AbstractPage {


    private WebDriverWait wait;

    private By navBarAccountElement_hw6 = By.id("navbarAccount");
    private By loginButton_hw6 = By.id("loginButton");
    private By passwordInput_hw6 = By.id("password");
    private By emailInput_hw6 = By.id("email");
    private By clickOnLoginButtonAfterAcc = By.id("navbarLoginButton");
    private By bananaProduct = By.xpath(".//*[@class='item-name'][contains(., 'Banana')]");
    private By checkBananaProduct = By.xpath(".//*[h1 and contains(., 'Banana Juice (1000ml)')]");
    private By findBananaForUse = By.xpath(".//mat-card[contains(., 'Banana')]/div/button");
    private By bananaBasketPopupElement = By.xpath(".//snack-bar-container/simple-snack-bar/span");
    private By openBasket = By.xpath(".//*[@class='mat-focus-indicator buttons mat-button mat-button-base ng-star-inserted']");
    private By search = By.xpath(".//mat-table/mat-row/mat-cell[contains(., 'Banana')]");
    private By secondPage = By.xpath(".//*[@aria-label='Next page']");
    //    private By searchAProduct = By.xpath(".//mat-card[contains(., 'OWASP Juice Shop Coaster')]/div/button");
    private By owaspProd = By.xpath("//mat-card[contains(., 'OWASP Juice Shop Coaster')]/div/button");
    private By buskedButtonOwasp = By.xpath(".//snack-bar-container/simple-snack-bar/span");


    public CheckProductFluent_Lesson_6(WebDriver driver) {
        super(driver);

        this.wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {
        driver.get("http://3.18.213.48/#/");
    }


    public CheckProductFluent_Lesson_6 clickOnAccountButton() {
        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(navBarAccountElement_hw6);
        element.click();
        return this;
    }

    public CheckProductFluent_Lesson_6 clickOnLoginButtonAfterAcc() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(clickOnLoginButtonAfterAcc).click();
        return this;
    }


    public CheckProductFluent_Lesson_6 enterUserPassword_hw6(String pass) {
        System.out.println("Typing user password - " + pass);
        getDriver().findElement(passwordInput_hw6).sendKeys(pass);
        return this;
    }


    public CheckProductFluent_Lesson_6 enterUserEmail_hw6(String email) {
        System.out.println("Typing user email - " + email);
        getDriver().findElement(emailInput_hw6).sendKeys(email);
        return this;
    }


    public CheckProductFluent_Lesson_6 clickOnLoginButton() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginButton_hw6).click();
        return this;
    }


    public CheckProductFluent_Lesson_6 bananaProduct() {
        getDriver().findElement(bananaProduct).click();
        return this;
    }

    public WebElement checkBananaProduct() {
        WebElement banana = getDriver().findElement(checkBananaProduct);
        return banana;
    }

    public CheckProductFluent_Lesson_6 findBananaForUse() {
        getDriver().findElement(findBananaForUse).click();
        return this;
    }

    public String bananaBasketPopup() {
        WebElement bananaBasketPopup = getDriver().findElement(bananaBasketPopupElement);

        wait.until(ExpectedConditions.visibilityOf(bananaBasketPopup));
        String bananaBasketStr = bananaBasketPopup.getText();
        return bananaBasketStr;
    }

    public CheckProductFluent_Lesson_6 openABasket() {
        WebElement bananaBasketPopup = getDriver().findElement(bananaBasketPopupElement);
        wait.until(ExpectedConditions.visibilityOf(bananaBasketPopup));
        getDriver().findElement(openBasket);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(search)));
        return this;

    }

    public int bananaInTheBasked() {

        int bananaInBasket = getDriver().findElements(search).size();
        return bananaInBasket;
    }

    public CheckProductFluent_Lesson_6 nextPage() {
        WebElement nextPage = wait.until(ExpectedConditions.elementToBeClickable(secondPage));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", nextPage);
        nextPage.click();
        return this;
    }

    public CheckProductFluent_Lesson_6 owaspProduct() {
        WebElement owasp = getDriver().findElement(owaspProd);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(owaspProd)));
        owasp.click();
        return this;
    }

    public String owaspProductInBasket() {
        WebElement outOfStockPopup = getDriver().findElement(buskedButtonOwasp);
        wait.until(ExpectedConditions.visibilityOf(outOfStockPopup));
        String outOfStockPopupStr = outOfStockPopup.getText();
        return outOfStockPopupStr;
    }

}

