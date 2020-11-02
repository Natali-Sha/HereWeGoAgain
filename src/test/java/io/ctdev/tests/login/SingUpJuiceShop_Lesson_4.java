package io.ctdev.tests.login;

import io.ctdev.framework.config.TestConfig;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.model.Customer_hw6;
import io.ctdev.framework.pages.login_HW6.LoginFluent_Lesson_6;
import io.ctdev.framework.pages.login_HW6.RegisterFluent_Lesson_6;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.Random;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class SingUpJuiceShop_Lesson_4 {

//    Random rand = new Random(System.currentTimeMillis());
//    int uniqueLoginName = rand.nextInt(999999);

    private Customer_hw6 singUp;
    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private RegisterFluent_Lesson_6 fluentPageRegister_hw6;
    private RegisterFluent_Lesson_6 uniqueLoginName;


//
//    private String userName = "nat" + uniqueLoginName + "@ukr.net";
//    private String pass = "09876543217";
//    private String answer = "00.00.0000";

    @BeforeClass
    public void beforeSingUp() {

        //getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//       WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 5, 1000);

//        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        getDriver().get(TestConfig.cfg.baseUrl());
        getDriver().navigate().refresh();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class*='close-dialog']")));
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();

        singUp = Customer_hw6.newBuilder().withPass("09876543217").withAnswer("00.00.0000").build();
        fluentPageRegister_hw6 = new RegisterFluent_Lesson_6(driver);
    }

    @AfterClass
    public void tearDown() {

        WebDriverSingleton.closeDriver();
    }

    @Test
    public void userIsAbleSingUpToShop() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 7);

        fluentPageRegister_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().
                notYetCustomer_hw6().uniqueLoginName().switchToggle_hw6().inputUserPass(singUp.getPass()).
                repeatUserPass(singUp.getPass()).securityQuestion().selectSecurityQuestion().
                securityAnswer(singUp.getAnswer()).registerButton();

        wait.until(ExpectedConditions.urlToBe("http://3.18.213.48/#/login"));
        String getCurrentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(getCurrentUrl, "http://3.18.213.48/#/login", "Registration error");


//    @AfterClass
//    public void tearDown() {
//        System.out.println(uniqueLoginName);
//
//
////        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//
//        System.out.println("After Class: Login after sing-up");
//
////        getDriver().findElement(By.id("email")).clear();
//        System.out.println("Typing user email - " + userName);
//        getDriver().findElement(By.id("email")).sendKeys(userName);
//
//        getDriver().findElement(By.id("password")).clear();
//        System.out.println("Typing user password - " + pass);
//        getDriver().findElement(By.id("password")).sendKeys(pass);
//
//        System.out.println("Clicking on Login button");
//        getDriver().findElement(By.id("loginButton")).click();
//
//        System.out.println("Deleting an account");
//
//        System.out.println("Clicking on Account button");
//        WebElement element = getDriver().findElement(By.id("navbarAccount"));
//        element.click();
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(.//*[@aria-label='Show Privacy and Security Menu'])[2]")));
//
//        System.out.println("Selecting 'Privacy and Security'");
//        getDriver().findElement(By.xpath("(.//*[@aria-label='Show Privacy and Security Menu'])[2]")).click();
//
//        System.out.println("Selecting 'Request Data Erasure'");
//        getDriver().findElement(By.xpath(".//*[@aria-label='Go to data subject page']")).click();
//
//        System.out.println("Typing user email - " + userName);
//        getDriver().findElement(By.id("email")).sendKeys(userName);
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("securityAnswer")));
//
//        System.out.println("Typing answer - " + answer);
//        getDriver().findElement(By.id("securityAnswer")).sendKeys(answer);
//
//        System.out.println("Clicking on 'Delete user data' button");
//        getDriver().findElement(By.id("deleteUserButton")).click();
//
//        System.out.println("Close driver");
//        WebDriverSingleton.closeDriver();
//
//        public void tearDown() { WebDriverSingleton.closeDriver(); }
//
//
//    }
////
//    @Test
//    public void userIsAbleToLoginToShop(){
//
//
//
//        wait.until(ExpectedConditions.urlToBe("http://3.18.213.48/#/login"));
//
//        String getCurrentUrl = getDriver().getCurrentUrl();
//        Assert.assertEquals(getCurrentUrl, "http://3.18.213.48/#/login", "Registration error");


//        WebDriverWait wait = new WebDriverWait(getDriver(), 7);
//
//
//        System.out.println("Clicking on Account button");
//        WebElement element = getDriver().findElement(By.id("navbarAccount"));
//        element.click();
//
//        System.out.println("Clicking on Login button");
//        getDriver().findElement(By.id("navbarLoginButton")).click();
//
//        System.out.println("Clicking on 'Not yet customer?' link");
//        getDriver().findElement(By.id("newCustomerLink")).click();
//
//        System.out.println("Typing user email - " + userName);
//        getDriver().findElement(By.id("emailControl")).sendKeys(userName);
//
//        System.out.println("Switch on 'Show password advice' toggle  - ON");
//        getDriver().findElement(By.xpath(".//*[@class='mat-slide-toggle-thumb']")).click();
//
//        System.out.println("Typing user password - " + pass);
//        getDriver().findElement(By.id("passwordControl")).sendKeys(pass);
//
//        System.out.println("Repeat user password - " + pass);
//        getDriver().findElement(By.id("repeatPasswordControl")).sendKeys(pass);
//
//        System.out.println("Switch on 'Show password advice' toggle - OFF");
//        getDriver().findElement(By.xpath(".//*[@class='mat-slide-toggle-thumb']")).click();
//
//        System.out.println("Clicking on Security Question");
//        getDriver().findElement(By.xpath(".//*[@name='securityQuestion']")).click();
//
//        System.out.println("Selecting Security Question ");
//        getDriver().findElement(By.xpath(".//*[@id='mat-option-5']")).click();
//
//        System.out.println("Typing answer - " + answer);
//        getDriver().findElement(By.id("securityAnswerControl")).sendKeys(answer);
//
//
//        System.out.println("Clicking on Register button");
//
//
//        WebElement registerButton = getDriver().findElement(By.id("registerButton"));
//
//
//        registerButton.click();
////
//        wait.until(ExpectedConditions.urlToBe("http://3.18.213.48/#/login"));
//
//        String getCurrentUrl = getDriver().getCurrentUrl();
//        Assert.assertEquals(getCurrentUrl, "http://3.18.213.48/#/login", "Registration error");

    }
}
//This will scroll the web page till end.
//        js.executeScript("window.scrollBy(0,100)");
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//      wait.until(ExpectedConditions.stalenessOf());

//        WebElement registerButton = getDriver().findElement(By.id("registerButton"));
//        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(getDriver().findElement(By.xpath(".//*[@href='#/login']")));
//        registerButton.click()

