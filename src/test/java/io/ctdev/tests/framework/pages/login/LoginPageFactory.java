package io.ctdev.tests.framework.pages.login;

import io.ctdev.tests.framework.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.ctdev.tests.framework.driver.WebDriverSingleton.getDriver;

public class LoginPageFactory extends AbstractPage {

    //    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(id = "navbarAccount")
    private WebElement navBarAccountElement;

    private By goToUserProfile = By.cssSelector("[aria-label='Go to user profile'] span");
//    @FindBy (css ="[aria-label='Go to user profile'] span")
//    private WebElement goToUserProfile;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "navbarLoginButton")
    private WebElement loginSubmitButton;


    //    private By navBarAccountElement = By.id("navbarAccount");
//    private By goToUserProfile = By.cssSelector("[aria-label='Go to user profile'] span");
//    private By loginButton = By.id("loginButton");
//    private By passwordInput = By.id("password");
//    private By emailInput = By.id("email");
//    private By loginSubmitButton = By.id("navbarLoginButton");
//    private String elementByText = "//*[@text=%s"];


    public LoginPageFactory(WebDriver driver) {
        super(driver);
//        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIME_OUT);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        driver.get("http://3.18.213.48/#/" + "login");
    }

    public String getCurrentLoggedUserName() {
        navBarAccountElement.click();
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(goToUserProfile));
        return userNameElement.getAttribute("innerText").trim();
    }

    public LoginPageFactory submitLoginForUser() {
        System.out.println("Clicking on Login button");
        loginButton.click();
        return this;
    }

    public LoginPageFactory enterUserPassword(String password) {
        System.out.println("Typing user password - " + password);
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPageFactory enterUserEmail(String email) {
        System.out.println("Typing user email - " + email);
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPageFactory clickOnLoginButton() {
        System.out.println("Clicking on Login button");
        loginSubmitButton.click();
        return this;
    }

    public LoginPageFactory clickOnAccountButton() {
        System.out.println("Clicking on Account button");
        navBarAccountElement.click();
        return this;
    }

//    public void searchElementByText(String text) {
//        driver.findElement(By.xpath(String.format(elementByText, text));
//    }


}
