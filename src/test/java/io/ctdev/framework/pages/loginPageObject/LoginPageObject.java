package io.ctdev.framework.pages.loginPageObject;

import io.ctdev.framework.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class LoginPageObject extends AbstractPage {


    private WebDriverWait wait;

    private By accountButtonOnMainPage = By.id("navbarAccount");
    private By mainPageLoginButton = By.id("navbarLoginButton");
    private By emailIOnLoginPage = By.id("email");
    private By passwordOnLoginPage = By.id("password");
    private By loginButtonOnLoginPage = By.id("loginButton");
    private By loggedUserProfileName = By.cssSelector("[aria-label='Go to user profile'] span");
    private By closePopUpOnMainPage = By.cssSelector("[class*='close-dialog']");




    public LoginPageObject(WebDriver driver) {
        super(driver);

        this.wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {
        getDriver().get("http://3.18.213.48/#/");
    }

    public String getCurrentLoggedUserName() {
        getDriver().findElement(accountButtonOnMainPage).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), TIME_OUT);
        WebElement userNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(loggedUserProfileName));
        return userNameElement.getAttribute("innerText").trim();
    }

    public LoginPageObject submitLoginForUser() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginButtonOnLoginPage).click();
        return this;
    }

    public LoginPageObject enterUserPasswordOnLoginPage(String password) {
        System.out.println("Typing user password - " + password);
        getDriver().findElement(passwordOnLoginPage).sendKeys(password);
        return this;
    }


    public LoginPageObject enterUserEmailPasswordOnLoginPage(String email) {
        System.out.println("Typing user email - " + email);
        getDriver().findElement(emailIOnLoginPage).sendKeys(email);
        return this;
    }

    public LoginPageObject clickOnLoginButtonOnMainPage() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(mainPageLoginButton).click();
        return this;
    }

    public LoginPageObject clickOnAccountButtonOnMainPage() {
        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(accountButtonOnMainPage);
        element.click();
        return this;
    }

    public LoginPageObject clearEmailFieldOnLoginPage() {
        getDriver().findElement(emailIOnLoginPage).clear();
        return this;
    }

    public LoginPageObject clearPasswordFieldOnLoginPage() {
        getDriver().findElement(passwordOnLoginPage).clear();
        return this;
    }

    public String findLoginButtonAttribute() {
        WebElement findLoginButton = getDriver().findElement(loginButtonOnLoginPage);
        String findLoginButtonAttribute = findLoginButton.getAttribute("disabled");
        return findLoginButtonAttribute;
    }

    public LoginPageObject clickForClosePopUpOnMainPage() {
        getDriver().findElement(closePopUpOnMainPage).click();
        return this;
    }


}