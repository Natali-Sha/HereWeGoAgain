package io.ctdev.framework.pages.login_HW6;

import io.ctdev.framework.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class RegisterFluent_Lesson_6 extends AbstractPage {


    private WebDriverWait wait;

    private By navBarAccountElement_hw6 = By.id("navbarAccount");
    private By goToUserProfile_hw6 = By.cssSelector("[aria-label='Go to user profile'] span");
    private By loginButton_hw6 = By.id("loginButton");
    private By passwordInput_hw6 = By.id("password");
    private By emailInput_hw6 = By.id("email");
    private By loginSubmitButton_hw6 = By.id("navbarLoginButton");
    private By notYetCustomer_hw6   = By.id("newCustomerLink");
    private By uniqueLoginNameInput = By.id("emailControl");
    private By switchToggle_hw6 = By.xpath(".//*[@class='mat-slide-toggle-thumb']");
    private By userPass_hw6 = By.id("passwordControl");
    private By repeatUserPass_hw6 = By.id("repeatPasswordControl");
    private By securityQuestion = By.xpath(".//*[@name='securityQuestion']");
    private By selectSecurityQuestion = By.xpath(".//*[@id='mat-option-5']");
    private By securityAnswer = By.id("securityAnswerControl");
    private By registerButtonL = By.id("registerButton");
    private By selectPrivacyAndSecurity = By.xpath("(.//*[@aria-label='Show Privacy and Security Menu'])[2]");
    private By requestDataErasure = By.xpath(".//*[@aria-label='Go to data subject page']");
    private By deleteUserData = By.id("deleteUserButton");


private String uniqueLoginNameSt;

    public RegisterFluent_Lesson_6(WebDriver driver) {
        super(driver);

        this.wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {
        driver.get("http://3.18.213.48/#/");
    }


    public RegisterFluent_Lesson_6 clickOnAccountButton_hw6() {
        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(navBarAccountElement_hw6);
        element.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSubmitButton_hw6));

        return this;
    }

    public RegisterFluent_Lesson_6 clickOnLoginButton_hw6() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSubmitButton_hw6);
        System.out.println("Clicking on Login button");
        getDriver().findElement(loginSubmitButton_hw6).click();
        return this;
    }


    public RegisterFluent_Lesson_6 notYetCustomer_hw6() {
        System.out.println("Clicking on 'Not yet customer?' link");
        getDriver().findElement(notYetCustomer_hw6).click();
        return this;
    }


    public RegisterFluent_Lesson_6 uniqueLoginName() {
        Random rand = new Random(System.currentTimeMillis());
        int uniqueLoginName = rand.nextInt(999999);
        uniqueLoginNameSt = "nat" + uniqueLoginName + "@ukr.net";
        System.out.println("Typing user email - " + uniqueLoginNameSt);
        getDriver().findElement(uniqueLoginNameInput).sendKeys(uniqueLoginNameSt);
        return this;
    }

    public RegisterFluent_Lesson_6 switchToggle_hw6() {
        System.out.println("Switch on 'Show password advice' toggle  - ON");
        getDriver().findElement(switchToggle_hw6).click();
        return this;
    }


    public RegisterFluent_Lesson_6 inputUserPass(String pass) {
        System.out.println("Typing user password - " + pass);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("passwordControl")));
        getDriver().findElement(userPass_hw6).sendKeys(pass);
        return this;
    }


    public RegisterFluent_Lesson_6 repeatUserPass(String pass) {
        System.out.println("Repeat user password - " + pass);
        getDriver().findElement(repeatUserPass_hw6).sendKeys(pass);
        return this;
    }

    public RegisterFluent_Lesson_6 securityQuestion() {
        System.out.println("Clicking on Security Question");
        getDriver().findElement(securityQuestion).click();
        return this;
    }

    public RegisterFluent_Lesson_6 selectSecurityQuestion() {
        System.out.println("Selecting Security Question ");
        getDriver().findElement(selectSecurityQuestion).click();
        return this;
    }

    public RegisterFluent_Lesson_6 securityAnswer(String answer) {
        System.out.println("Typing answer - " + answer);
        getDriver().findElement(securityAnswer).sendKeys(answer);
        return this;
    }


    public RegisterFluent_Lesson_6 registerButton () {
        System.out.println("Clicking on Register button");
        WebElement registerButton = getDriver().findElement(registerButtonL);
        registerButton.click();
        return this;
    }

//    public RegisterFluent_Lesson_6 loginInto() {
//        System.out.println("Typing user email - " + uniqueLoginName());
//        getDriver().findElement(emailInput_hw6).sendKeys();
//        return this;
//    }
//
//    public RegisterFluent_Lesson_6 enterUserPassword_hw6(String pass) {
//        System.out.println("Typing user password - " + pass);
//        getDriver().findElement(passwordInput_hw6).sendKeys(pass);
//        return this;
//    }
//
//
//    public RegisterFluent_Lesson_6 clickOnLoginButton() {
//        System.out.println("Clicking on Login button");
//        getDriver().findElement(loginButton_hw6).click();
//        return this;
//    }
//
//    public RegisterFluent_Lesson_6 privacyAndSecurity() {
//        System.out.println("Selecting 'Privacy and Security'");
//        getDriver().findElement(selectPrivacyAndSecurity).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(.//*[@aria-label='Show Privacy and Security Menu'])[2]")));
//        return this;
//    }
//
//    public RegisterFluent_Lesson_6 requestDataErasure() {
//        System.out.println("Selecting 'Request Data Erasure'");
//        getDriver().findElement(By.xpath(".//*[@aria-label='Go to data subject page']")).click();
//        return this;
//    }
//
//    public RegisterFluent_Lesson_6 deleteUserData() {
//        System.out.println("Clicking on 'Delete user data' button");
//        getDriver().findElement(deleteUserData).click();
//        return this;
//    }

    public String getUniqueLoginNameSt() {
        return uniqueLoginNameSt;
    }

//
//    public String getCurrentLoggedUserName_hw6() {
//        getDriver().findElement(navBarAccountElement_hw6).click();
//        WebElement userNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(goToUserProfile_hw6));
//
//        return userNameElement.getAttribute("innerText").trim();
//    }
//
//    public RegisterFluent_Lesson_6 submitLoginForUser_hw6() {
//        System.out.println("Clicking on Login button");
//        getDriver().findElement(loginButton_hw6).click();
//        return this;
//    }
//
//
//
//
//
//
//
//    public RegisterFluent_Lesson_6 clearDataEmail() {
//        getDriver().findElement(emailInput_hw6).clear();
//        return this;
//    }
//
//    public RegisterFluent_Lesson_6 clearDataPassword() {
//        getDriver().findElement(passwordInput_hw6).clear();
//        return this;
//    }
//
//    public String findLoginButtonAttribute() {
//        WebElement findLoginButton = getDriver().findElement(loginButton_hw6);
//        String findLoginButtonAttribute = findLoginButton.getAttribute("disabled");
//        return findLoginButtonAttribute;
//    }
//
//
//
}