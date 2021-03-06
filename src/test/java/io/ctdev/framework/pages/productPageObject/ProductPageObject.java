package io.ctdev.framework.pages.productPageObject;

import io.ctdev.framework.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class ProductPageObject extends AbstractPage {


    private WebDriverWait waitProductFluent;

    private By navBarAccountElementHw6 = By.id("navbarAccount");
    private By loginButtonHw6 = By.id("loginButton");
    private By passwordInputHw6 = By.id("password");
    private By emailInputHw6 = By.id("email");
    private By clickOnLoginButtonAfterAcc = By.id("navbarLoginButton");
    private By bananaProduct = By.xpath(".//*[@class='item-name'][contains(., 'Banana')]");
    private By checkBananaProduct = By.xpath(".//*[h1 and contains(., 'Banana Juice (1000ml)')]");
    private By findBananaForUse = By.xpath(".//mat-card[contains(., 'Banana')]/div/button");
    private By bananaBasketPopupElement = By.xpath(".//snack-bar-container/simple-snack-bar/span");
    private By openBasket = By.xpath(".//*[@class='mat-focus-indicator buttons mat-button mat-button-base ng-star-inserted']");
    private By search = By.xpath(".//mat-table/mat-row/mat-cell[contains(., 'Banana')]");
    private By secondPage = By.xpath(".//*[@aria-label='Next page']");
    private By owaspProd = By.xpath("//mat-card[contains(., 'OWASP Juice Shop Coaster')]/div/button");
    private By buskedButtonOwasp = By.xpath(".//snack-bar-container/simple-snack-bar/span");
    private By mainLogoButton = By.xpath(".//*[@class='mat-focus-indicator buttons mat-button mat-button-base']");
    private By closeDialogSelector = By.cssSelector("[class*='close-dialog']");
    private By addProduct = By.xpath(".//mat-card[contains(., 'Banana')]/div/button");
    private By nameBanana = By.xpath(".//h1");
    private By descriptionBanana = By.xpath(".//div");
    private By priceBanana = By.xpath(".//div/p");

    ;


    public ProductPageObject(WebDriver driver, WebDriverWait waitProductFluent) {
        super(driver);
        this.waitProductFluent = waitProductFluent;
    }

    @Override
    public void openPage() {
        getDriver().get("http://3.18.213.48/#/");
    }

    public ProductPageObject clickOnAccountButton() {
        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(navBarAccountElementHw6);
        element.click();
        return this;
    }

    public ProductPageObject clickOnLoginButtonAfterAcc() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(clickOnLoginButtonAfterAcc).click();
        return this;
    }


    public ProductPageObject enterUserPassword_hw6(String pass) {
        System.out.println("Typing user password - " + pass);
        getDriver().findElement(passwordInputHw6).sendKeys(pass);
        return this;
    }

    public ProductPageObject enterUserEmail_hw6(String email) {
        System.out.println("Typing user email - " + email);
        getDriver().findElement(emailInputHw6).sendKeys(email);
        return this;
    }

    public ProductPageObject clickOnLoginButton() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginButtonHw6).click();
        return this;
    }

    public ProductPageObject addBananaProduct() {
        getDriver().findElement(bananaProduct).click();
        return this;
    }

    public WebElement checkBananaProduct() {

        WebElement banana = getDriver().findElement(checkBananaProduct);
        return banana;
    }

    public ProductPageObject findBananaForUse() {
        getDriver().findElement(findBananaForUse).click();
        return this;
    }

    public String bananaBasketPopup() {
        WebElement bananaBasketPopup = getDriver().findElement(bananaBasketPopupElement);

        waitProductFluent.until(ExpectedConditions.visibilityOf(bananaBasketPopup));
        String bananaBasketStr = bananaBasketPopup.getText();
        return bananaBasketStr;
    }

    public ProductPageObject openABasket() {
        WebElement bananaBasketPopup = getDriver().findElement(bananaBasketPopupElement);
        waitProductFluent.until(ExpectedConditions.visibilityOf(bananaBasketPopup));
        getDriver().findElement(openBasket).click();
        return this;
    }

    public int bananaInTheBasked() {
        waitProductFluent.until(ExpectedConditions.visibilityOf(getDriver().findElement(search)));
        System.out.println("13");

        int bananaInBasket = getDriver().findElements(search).size();
        return bananaInBasket;
    }

    public ProductPageObject nextPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(secondPage));
        WebElement nextPage = getDriver().findElement(secondPage);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", nextPage);
        nextPage.click();
        return this;
    }

    public ProductPageObject owaspProduct() {
        WebElement owasp = getDriver().findElement(owaspProd);
        waitProductFluent.until(ExpectedConditions.visibilityOf(getDriver().findElement(owaspProd)));
        owasp.click();
        return this;
    }

    public String owaspProductInBasket() {
        WebElement outOfStockPopup = getDriver().findElement(buskedButtonOwasp);
        waitProductFluent.until(ExpectedConditions.visibilityOf(outOfStockPopup));
        String outOfStockPopupStr = outOfStockPopup.getText();
        return outOfStockPopupStr;
    }

    public ProductPageObject clickOnMainLogoButton() {
        getDriver().findElement(mainLogoButton).click();
        return this;
    }

    public ProductPageObject closeDialogProduct() {
        getDriver().findElement(closeDialogSelector).click();
        return this;
    }

    public String nameOfProductGetText() {
        String name = getDriver().findElement(nameBanana).getText();
        return name;
    }

    public String descriptionOfProductGetText() {
        String description = getDriver().findElement(descriptionBanana).getText();
        return description;
    }

    public String priceOfProductGetText() {
        String price = getDriver().findElement(priceBanana).getText();
        return price;
    }

    public ProductPageObject bananaBasket() {
        getDriver().findElement(addProduct).click();
        return this;
    }
}

