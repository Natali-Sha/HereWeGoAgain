package io.ctdev.tests.login;

import io.ctdev.framework.model.Customer_hw6;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.pages.login_HW6.LoginFluent_Lesson_6;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class NegativeTestsForLogin_Lesson_4 {

    private Customer_hw6 customerLogin;
    private Customer_hw6 customerInvalidLogin;

    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private LoginFluent_Lesson_6 fluentPage_hw6;

//    private String userName = "natali6@ukr.net";
//    private String invalidUserName = "natali6ukr.net";
//    private String invalidPass = "12345678900";
//    private String pass = "09876543216";
//    WebDriver driver = getDriver();
//    WebDriverWait wait;

    @BeforeClass
    public void SetUp() {

        getDriver().get("http://3.18.213.48/#/");

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='close-dialog']")));
//        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();

        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();

        customerLogin = Customer_hw6.newBuilder().withName("natali6@ukr.net").withPassword("09876543216").build();
        customerInvalidLogin = Customer_hw6.newBuilder().withInvalidUsername("natali6ukr.net").withInvalidPass("123456789").build();
        fluentPage_hw6 = new LoginFluent_Lesson_6(driver);
    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

    @AfterMethod
    public void clearData() {

        fluentPage_hw6.clearDataEmail();
        fluentPage_hw6.clearDataPassword();
        getDriver().navigate().refresh();
    }

    @Test
    public void notPossibleToLoginWithoutEmail(){
        fluentPage_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().
                enterUserPassword_hw6(customerLogin.getEmail());

        fluentPage_hw6.findLoginButtonAttribute();

        Assert.assertEquals(fluentPage_hw6.findLoginButtonAttribute(), "true", "Login button is enabled w/o user email.");

//        System.out.println("Typing user password");
//        getDriver().findElement(By.id("password")).sendKeys(pass);
//
//        System.out.println("Clicking on Login button");
//        WebElement logButton = getDriver().findElement(By.id("loginButton"));
//       String visible = fi.getAttribute("disabled");
//
//        Assert.assertEquals(visible, "true", "Login button is enabled w/o user email.");

//        getDriver().navigate().refresh();
    }

    @Test
    public void notPossibleToLoginWithoutPass(){

        fluentPage_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().
                enterUserEmail_hw6(customerLogin.getEmail());

        fluentPage_hw6.findLoginButtonAttribute();
        Assert.assertEquals(fluentPage_hw6.findLoginButtonAttribute(), "true", "Login button is enabled w/o user email.");

//        System.out.println("Typing user email - " + userName);
//        getDriver().findElement(By.id("email")).sendKeys(userName);
//
//        System.out.println("Clicking on Login button");
//        WebElement logButton = getDriver().findElement(By.id("loginButton"));
//        String visible = logButton.getAttribute("disabled");
//
//        Assert.assertEquals(visible, "true", "Login button is enabled w/o user password.");

//        getDriver().navigate().refresh();
    }

    @Test
    public void notPossibleToLoginWithInvalidPass(){

        fluentPage_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().
                enterUserEmail_hw6(customerLogin.getEmail()).enterUserPassword_hw6(customerInvalidLogin.getInvalidPass()).
                submitLoginForUser_hw6();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")));

        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")).size() > 0, "Warning massage 'Invalid email or password.' is not shown");

//        System.out.println("Typing user email - " + userName);
//        getDriver().findElement(By.id("email")).sendKeys(userName);
//
//        System.out.println("Typing user password");
//        getDriver().findElement(By.id("password")).sendKeys(invalidPass);
//
//        System.out.println("Clicking on Login button");
//        getDriver().findElement(By.id("loginButton")).click();
//
//        Thread.sleep(3000);
//
//        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")).size() > 0, "Warning massage 'Invalid email or password.' is not shown");

    }

    //
    @Test
    public void notPossibleToLoginWithInvalidEmail(){

        fluentPage_hw6.clickOnAccountButton_hw6().clickOnLoginButton_hw6().
                enterUserEmail_hw6(customerLogin.getEmail()).enterUserPassword_hw6(customerInvalidLogin.getInvalidUserName()).
                submitLoginForUser_hw6();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")));

        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")).size() > 0, "Warning massage 'Invalid email or password.' is not shown");

//        System.out.println("Typing user email - " + invalidUserName);
//        getDriver().findElement(By.id("email")).sendKeys(invalidUserName);
//
//        System.out.println("Typing user password");
//        getDriver().findElement(By.id("password")).sendKeys(pass);
//
//        System.out.println("Clicking on Login button");
//        getDriver().findElement(By.id("loginButton")).click();
//
//        Thread.sleep(3000);
//
//        Assert.assertTrue(getDriver().findElements(By.xpath(".//*[contains(@class, 'error ng-star-inserted')]")).size() > 0, "Warning massage 'Invalid email or password.' is not shown");
//
    }

}