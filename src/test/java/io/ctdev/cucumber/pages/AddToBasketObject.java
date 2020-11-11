package io.ctdev.cucumber.pages;

import io.ctdev.framework.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class AddToBasketObject extends AbstractPage {

    private WebDriverWait wait;
    private WebDriver driver;
    public AddToBasketObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIME_OUT);
    }

    private WebDriverWait waitAddProduct;

    private By searchProduct = By.xpath("//input[@name='search']");
    private By searchButton = By.xpath(".//*[@class='button button_color_green button_size_medium search-form__submit']");
    private By findBasketInProduct = By.cssSelector("[data-goods-id*='250490641'] [extclass*='goods-tile__buy-button']");
    private By basketButton = By.xpath(".//*[@class='header-actions__item header-actions__item_type_cart']");
    private By findInBasket = By.cssSelector("[class*='cart-product'] [class*='cart-product__title']");
    private By suggestList = By.cssSelector("[class*='search-suggest'] [class*='suggest-list']");
    private By basketCounter = By.cssSelector("[class*='header-actions__button-counter']");


    @Override
    public void openPage() {
        getDriver().get("https://rozetka.com.ua/");
    }

    @Step
    public AddToBasketObject inputInTheSearchField(String request) {
        wait.until(ExpectedConditions.elementToBeClickable(searchProduct)).sendKeys(request);
//        getDriver().findElement(searchProduct)
        return this;
    }

    @Step
    public AddToBasketObject clickOnTheSearchButton() {
//        getDriver().;
        wait.until(ExpectedConditions.presenceOfElementLocated(suggestList));
        getDriver().findElement(searchButton).sendKeys(Keys.RETURN);
//        getDriver().findElement(searchButton).click();
        return this;
    }

    @Step
    public AddToBasketObject addProductToBasket() {
        wait.until(ExpectedConditions.presenceOfElementLocated(findBasketInProduct));
        getDriver().findElement(findBasketInProduct).click();
        return this;
    }

    @Step
    public AddToBasketObject clickOnBasketButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(basketCounter));
        getDriver().findElement(basketButton).click();
        return this;
    }

    @Step
    public String productName() {
        String nameProduct = getDriver().findElement(findInBasket).getAttribute("title");
        return nameProduct;
    }

    @Step
    public String expectedProductName() {
        String name = "Генератор бензиновый RZTK G 3500E ";
        return name;
    }

//
//    title="Генератор бензиновый RZTK G 3500E "


}

