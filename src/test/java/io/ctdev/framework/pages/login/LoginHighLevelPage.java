package io.ctdev.framework.pages.login;

import io.ctdev.framework.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class LoginHighLevelPage extends AbstractPage {

//    private WebDriver driver;
    private WebDriverWait wait;

    private By navBarAccountElement = By.id("navbarAccount");
    private By goToUserProfile = By.cssSelector("[aria-label='Go to user profile'] span");
    private By loginButton = By.id("loginButton");
    private By passwordInput = By.id("password");
    private By emailInput = By.id("email");
    private By loginSubmitButton = By.id("navbarLoginButton");
//    private String elementByText = "//*[@text=%s";


    public LoginHighLevelPage(WebDriver driver) {
        super(driver);
//        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {
        driver.get("http://3.18.213.48/#/" + "login");
    }

    public String getCurrentLoggedUserName() {
        getDriver().findElement(navBarAccountElement).click();
        WebElement userNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(goToUserProfile));
        return userNameElement.getAttribute("innerText").trim();
    }

    public void submitLoginForUser() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginButton).click();
    }

    public void enterUserPassword(String password) {
        System.out.println("Typing user password - " + password);
        getDriver().findElement(passwordInput).sendKeys(password);
    }

    public void enterUserEmail(String email) {
        System.out.println("Typing user email - " + email);
        getDriver().findElement(emailInput).sendKeys(email);
    }

    public void clickOnLoginButton() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginSubmitButton).click();
    }

    public void clickOnAccountButton() {
        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(navBarAccountElement);
        element.click();
    }

//    public void searchElementByText(String text) {
//        driver.findElement(By.xpath(String.format(elementByText, text));
//    }


}
