package io.ctdev.framework.pages.login_HW6;

import io.ctdev.framework.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class LoginFluentLesson6 extends AbstractPage {


    private WebDriverWait wait;

    private By navBarAccountElementHw6 = By.id("navbarAccount");
    private By goToUserProfileHw6 = By.cssSelector("[aria-label='Go to user profile'] span");
    private By loginButtonHw6 = By.id("loginButton");
    private By passwordInputHw6 = By.id("password");
    private By emailInputHw6 = By.id("email");
    private By loginSubmitButtonHw6 = By.id("navbarLoginButton");
    private By closeDialogLogin = By.cssSelector("[class*='close-dialog']");




    public LoginFluentLesson6(WebDriver driver) {
        super(driver);

        this.wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {
        driver.get("http://3.18.213.48/#/");
    }

    public String getCurrentLoggedUserName_hw6() {
        getDriver().findElement(navBarAccountElementHw6).click();
        WebElement userNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(goToUserProfileHw6));
        return userNameElement.getAttribute("innerText").trim();
    }

    public LoginFluentLesson6 submitLoginForUser_hw6() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginButtonHw6).click();
        return this;
    }

    public LoginFluentLesson6 enterUserPassword_hw6(String password) {
        System.out.println("Typing user password - " + password);
        getDriver().findElement(passwordInputHw6).sendKeys(password);
        return this;
    }


    public LoginFluentLesson6 enterUserEmail_hw6(String email) {
        System.out.println("Typing user email - " + email);
        getDriver().findElement(emailInputHw6).sendKeys(email);
        return this;
    }

    public LoginFluentLesson6 clickOnLoginButton_hw6() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginSubmitButtonHw6).click();
        return this;
    }

    public LoginFluentLesson6 clickOnAccountButton_hw6() {
        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(navBarAccountElementHw6);
        element.click();
        return this;
    }

    public LoginFluentLesson6 clearDataEmail() {
        getDriver().findElement(emailInputHw6).clear();
        return this;
    }

    public LoginFluentLesson6 clearDataPassword() {
        getDriver().findElement(passwordInputHw6).clear();
        return this;
    }

    public String findLoginButtonAttribute() {
        WebElement findLoginButton = getDriver().findElement(loginButtonHw6);
        String findLoginButtonAttribute = findLoginButton.getAttribute("disabled");
        return findLoginButtonAttribute;
    }

    public LoginFluentLesson6 closeDialogLogin() {
        getDriver().findElement(closeDialogLogin).click();
        return this;
    }


}