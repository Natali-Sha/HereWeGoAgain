package io.ctdev.tests.login;

import io.ctdev.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class ValidationRegisterPageLesson4 {

    private String pass = "12345678";
    private String repeatPass = "87654321";
    private String password_4 = "1234";
    private String password_21 = "123456789012345678901";
    private String email = "1234";
    private String emailString = "nataliukr.net";
    private WebDriverWait wait;


    @BeforeClass
    public void beforeTests() {

        getDriver().get("http://3.18.213.48/#/");

        wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='close-dialog']")));
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();

        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(By.id("navbarAccount"));
        element.click();

        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("navbarLoginButton")).click();

        System.out.println("Clicking on 'Not yet customer?' link");
        getDriver().findElement(By.id("newCustomerLink")).click();
    }

    @AfterClass
    public void afterTests() {
        WebDriverSingleton.closeDriver();
    }

    @AfterMethod
    public void clearData() {
        getDriver().findElement(By.id("passwordControl")).clear();
        getDriver().findElement(By.id("emailControl")).clear();
        getDriver().findElement(By.id("repeatPasswordControl")).clear();
        getDriver().findElement(By.id("securityAnswerControl")).clear();
        getDriver().navigate().refresh();
    }

    @Test
    public void numberOfCharactersInField_Password_4char() {

        WebElement passError = getDriver().findElement(By.xpath(".//*[@id='passwordControl']"));
        passError.sendKeys(password_4);
        getDriver().findElement(By.id("repeatPasswordControl")).click();
        String isInvalid = passError.getAttribute("aria-invalid");

        Assert.assertEquals(isInvalid, "true", "Warning 'Password must be 5-20 characters long' is shown");
    }

    @Test
    public void numberOfCharactersInField_Password_21char() {

        WebElement passError = getDriver().findElement(By.xpath(".//*[@id='passwordControl']"));
        passError.sendKeys(password_21);
        getDriver().findElement(By.id("repeatPasswordControl")).click();
        String isInvalid = passError.getAttribute("aria-invalid");

        Assert.assertEquals(isInvalid, "true", "Warning 'Password must be 5-20 characters long' is shown");
    }

    @Test
    public void isNotValid_EmailAddress_int() {

        WebElement mailInt = getDriver().findElement(By.xpath(".//*[@id='emailControl']"));
        mailInt.sendKeys(email);
        getDriver().findElement(By.id("passwordControl")).click();
        String isInvalid = mailInt.getAttribute("aria-invalid");

        Assert.assertEquals(isInvalid, "true", "Warning 'Email address is not valid' is shown");
    }

    @Test
    public void isNotValid_EmailAddress_string() {
        WebElement mailString = getDriver().findElement(By.xpath(".//*[@id='emailControl']"));
        mailString.sendKeys(emailString);

        getDriver().findElement(By.id("passwordControl")).click();
        String isInvalid = mailString.getAttribute("aria-invalid");

        Assert.assertEquals(isInvalid, "true", "Warning 'Email address is not valid' is shown");
    }

    @Test
    public void passwordsDoNotMatch_RepeatPassword() {

        getDriver().findElement(By.xpath(".//*[@id='passwordControl']")).sendKeys(pass);

        WebElement repeatPassError = getDriver().findElement(By.xpath(".//*[@id='repeatPasswordControl']"));
        repeatPassError.sendKeys(repeatPass);
        getDriver().findElement(By.id("emailControl")).click();

        wait.until(ExpectedConditions.attributeContains(By.xpath(".//*[@id='repeatPasswordControl']"), "aria-invalid", "true"));


        String isInvalid = repeatPassError.getAttribute("aria-invalid");

        Assert.assertEquals(isInvalid, "true", "Warning 'Passwords do not match' is not shown");
    }

    @Test
    public void showPasswordAdvice_Toggle() {

        getDriver().findElement(By.xpath(".//*[@class='mat-slide-toggle-thumb']")).click();

        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, \"ng-tns-c136-\")]")).size() > 0, "Password Advice not shown!");
    }

    @Test
    public void securityQuestionsIsShown() {

        getDriver().findElement(By.xpath(".//*[@name='securityQuestion']")).click();

        Assert.assertTrue(getDriver().findElements(By.cssSelector("[id=cdk-overlay-0]")).size() > 0, "Security Questions not shown!");
    }

    @Test
    public void warningSecurityQuestionsIsShown_securityAnswer() {
        WebElement securityAnswer = getDriver().findElement(By.id("securityAnswerControl"));
        securityAnswer.click();

        getDriver().findElement(By.id("passwordControl")).click();
        String ariaInvalid = securityAnswer.getAttribute("aria-invalid");

        Assert.assertEquals(ariaInvalid, "true", "Please provide an answer to your security question");
    }
}
