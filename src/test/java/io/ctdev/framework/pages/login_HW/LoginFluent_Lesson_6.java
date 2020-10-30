package io.ctdev.framework.pages.login_HW;

import io.ctdev.framework.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class LoginFluent_Lesson_6 extends AbstractPage {


    private WebDriverWait wait;

    private By navBarAccountElement_hw6 = By.id("navbarAccount");
    private By goToUserProfile_hw6 = By.cssSelector("[aria-label='Go to user profile'] span");
    private By loginButton_hw6 = By.id("loginButton");
    private By passwordInput_hw6 = By.id("password");
    private By emailInput_hw6 = By.id("email");
    private By loginSubmitButton_hw6 = By.id("navbarLoginButton");




    public LoginFluent_Lesson_6(WebDriver driver) {
        super(driver);

        this.wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {
        driver.get("http://3.18.213.48/#/");
    }

    public String getCurrentLoggedUserName_hw6() {
        getDriver().findElement(navBarAccountElement_hw6).click();
        WebElement userNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(goToUserProfile_hw6));
        return userNameElement.getAttribute("innerText").trim();
    }

    public LoginFluent_Lesson_6 submitLoginForUser_hw6() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginButton_hw6).click();
        return this;
    }

    public LoginFluent_Lesson_6 enterUserPassword_hw6(String password) {
        System.out.println("Typing user password - " + password);
        getDriver().findElement(passwordInput_hw6).sendKeys(password);
        return this;
    }


    public LoginFluent_Lesson_6 enterUserEmail_hw6(String email) {
        System.out.println("Typing user email - " + email);
        getDriver().findElement(emailInput_hw6).sendKeys(email);
        return this;
    }

    public LoginFluent_Lesson_6 clickOnLoginButton_hw6() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginSubmitButton_hw6).click();
        return this;
    }

    public LoginFluent_Lesson_6 clickOnAccountButton_hw6() {
        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(navBarAccountElement_hw6);
        element.click();
        return this;
    }

    public LoginFluent_Lesson_6 clearDataEmail() {
        getDriver().findElement(emailInput_hw6).clear();
        return this;
    }

    public LoginFluent_Lesson_6 clearDataPassword() {
        getDriver().findElement(passwordInput_hw6).clear();
        return this;
    }

    public String findLoginButtonAttribute() {
        WebElement findLoginButton = getDriver().findElement(loginButton_hw6);
        String findLoginButtonAttribute = findLoginButton.getAttribute("disabled");
        return findLoginButtonAttribute;
    }


}