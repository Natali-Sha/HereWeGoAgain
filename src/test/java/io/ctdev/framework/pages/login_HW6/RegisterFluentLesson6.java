package io.ctdev.framework.pages.login_HW6;

import io.ctdev.framework.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class RegisterFluentLesson6 extends AbstractPage {


    private WebDriverWait wait;

    private By navBarAccountElementhw6Register = By.id("navbarAccount");
    private By goToUserProfileHw6Register = By.cssSelector("[aria-label='Go to user profile'] span");
    private By loginButtonHw6Register = By.id("loginButton");
    private By passwordInputHw6 = By.id("password");
    private By emailInputHw6 = By.id("email");
    private By loginSubmitButtonHw6 = By.id("navbarLoginButton");
    private By notYetCustomerHw6 = By.id("newCustomerLink");
    private By uniqueLoginNameInput = By.id("emailControl");
    private By switchToggleHw6 = By.xpath(".//*[@class='mat-slide-toggle-thumb']");
    private By userPassHw6 = By.id("passwordControl");
    private By repeatUserPassHw6 = By.id("repeatPasswordControl");
    private By securityQuestion = By.xpath(".//*[@name='securityQuestion']");
    private By selectSecurityQuestion = By.xpath(".//*[@id='mat-option-5']");
    private By securityAnswer = By.id("securityAnswerControl");
    private By registerButtonL = By.id("registerButton");
    private By selectPrivacyAndSecurity = By.xpath("(.//*[@aria-label='Show Privacy and Security Menu'])[2]");
    private By requestDataErasure = By.xpath(".//*[@aria-label='Go to data subject page']");
    private By deleteUserData = By.id("deleteUserButton");
    private By closeDialogSelector = By.cssSelector("[class*='close-dialog']");


private String uniqueLoginNameSt;

    public RegisterFluentLesson6(WebDriver driver) {
        super(driver);

        this.wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {
        driver.get("http://3.18.213.48/#/");
    }


    public RegisterFluentLesson6 clickOnAccountButton_hw6() {
        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(navBarAccountElementhw6Register);
        element.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSubmitButton_hw6));

        return this;
    }

    public RegisterFluentLesson6 clickOnLoginButton_hw6() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSubmitButton_hw6);
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginSubmitButtonHw6).click();
        return this;
    }


    public RegisterFluentLesson6 notYetCustomer_hw6() {
        System.out.println("Clicking on 'Not yet customer?' link");
        getDriver().findElement(notYetCustomerHw6).click();
        return this;
    }


    public RegisterFluentLesson6 uniqueLoginName() {
        Random rand = new Random(System.currentTimeMillis());
        int uniqueLoginName = rand.nextInt(999999);
        uniqueLoginNameSt = "nat" + uniqueLoginName + "@ukr.net";
        System.out.println("Typing user email - " + uniqueLoginNameSt);
        getDriver().findElement(uniqueLoginNameInput).sendKeys(uniqueLoginNameSt);
        return this;
    }

    public RegisterFluentLesson6 switchToggle_hw6() {
        System.out.println("Switch on 'Show password advice' toggle  - ON");
        getDriver().findElement(switchToggleHw6).click();
        return this;
    }


    public RegisterFluentLesson6 inputUserPass(String pass) {
        System.out.println("Typing user password - " + pass);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("passwordControl")));
        getDriver().findElement(userPassHw6).sendKeys(pass);
        return this;
    }


    public RegisterFluentLesson6 repeatUserPass(String pass) {
        System.out.println("Repeat user password - " + pass);
        getDriver().findElement(repeatUserPassHw6).sendKeys(pass);
        return this;
    }

    public RegisterFluentLesson6 securityQuestion() {
        System.out.println("Clicking on Security Question");
        getDriver().findElement(securityQuestion).click();
        return this;
    }

    public RegisterFluentLesson6 selectSecurityQuestion() {
        System.out.println("Selecting Security Question ");
        getDriver().findElement(selectSecurityQuestion).click();
        return this;
    }

    public RegisterFluentLesson6 securityAnswer(String answer) {
        System.out.println("Typing answer - " + answer);
        getDriver().findElement(securityAnswer).sendKeys(answer);
        return this;
    }


    public RegisterFluentLesson6 registerButton () {
        System.out.println("Clicking on Register button");
        WebElement registerButton = getDriver().findElement(registerButtonL);
        registerButton.click();
        return this;
    }


    public String getUniqueLoginNameSt() {
        return uniqueLoginNameSt;
    }

    public RegisterFluentLesson6 closeDialog() {
        getDriver().findElement(closeDialogSelector).click();
        return this;
    }


}