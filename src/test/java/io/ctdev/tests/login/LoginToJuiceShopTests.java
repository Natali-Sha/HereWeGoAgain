package io.ctdev.tests.login;

import io.ctdev.framework.config.TestConfig;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.ctdev.framework.model.Customer;
import io.ctdev.framework.pages.login.LoginFluentPage;
import io.ctdev.framework.pages.login.LoginPage;
import io.ctdev.framework.pages.login.LoginPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class LoginToJuiceShopTests {

//    private String userName = "dima@ukr.net";

    private Customer customer1;
    private Customer customer2;
    private WebDriver driver = getDriver();
    private WebDriverWait wait;
    private LoginPage loginPage;
    private LoginFluentPage fluentPage;
    private LoginPageFactory loginPageFactory;

//    WebDriver driver = getDriver();

//    WebDriverWait wait;

    @BeforeClass
    public void SetUp() {
//        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//   getDriver().get("http://3.18.213.48/#/");
        getDriver().get(TestConfig.cfg.baseUrl());
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();
        wait = new WebDriverWait(driver, 5);
        customer1 = Customer.newBuilder().withName("natali6@ukr.net").withPassword("09876543216").build();
        customer2 = Customer.newBuilder().withName("adadadad").build();
        loginPage = new LoginPage(driver);
        fluentPage = new LoginFluentPage(driver);
        loginPageFactory = new LoginPageFactory(driver);



//        private String userName = "natali6@ukr.net";
//        private String pass = "09876543216";
    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

    @Test
    public void userIsAbleToLoginToShop() throws InterruptedException {

        loginPage.clickOnAccountButton();


        loginPage.clickOnLoginButton();

        loginPage.enterUserEmail(customer1.getEmail());

        loginPage.enterUserPassword(customer1.getPassword());

        loginPage.submitLoginForUser();

        String actualUserName = loginPage.getCurrentLoggedUserName();

        Assert.assertEquals(actualUserName, customer1.getEmail(), "User name does not mach");


    }

    private String getCurrentLoggedUserName() {
        getDriver().findElement(By.id("navbarAccount")).click();
        WebElement userNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label='Go to user profile'] span")));
        return userNameElement.getAttribute("innerText").trim();
    }

    private void submitLoginForUser() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("loginButton")).click();
    }

    private void enterUserPassword() {
        System.out.println("Typing user password - " + customer1.getPassword());
        getDriver().findElement(By.id("password")).sendKeys(customer1.getPassword());
    }

    private void enterUserEmail() {
        System.out.println("Typing user email - " + customer1.getEmail());
        getDriver().findElement(By.id("email")).sendKeys(customer1.getEmail());
    }

    private void clickOnLoginButton() {
        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("navbarLoginButton")).click();
    }

    private void clickOnAccountButton() {
        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(By.id("navbarAccount"));
        element.click();
    }

    @Test
    public void userIsAbleToLoginToShopWithFluentInterface() throws InterruptedException {

        String actualUserName = fluentPage.clickOnAccountButton().
                clickOnLoginButton().enterUserEmail(customer1.getEmail()).
                enterUserPassword(customer1.getPassword()).
                submitLoginForUser().getCurrentLoggedUserName();

//        loginPage.clickOnLoginButton();
//        loginPage.enterUserEmail(customer1.getEmail());
//        loginPage.enterUserPassword(customer1.getPassword());
//        loginPage.submitLoginForUser();
//        String actualUserName = loginPage.getCurrentLoggedUserName();
        Assert.assertEquals(actualUserName, customer1.getEmail(), "User name does not mach");


    }

    @Test
    public void userIsAbleToLoginToShopWithPageFactory() throws InterruptedException {

        String actualUserName = loginPageFactory.clickOnAccountButton().
                clickOnLoginButton().enterUserEmail(customer1.getEmail()).
                enterUserPassword(customer1.getPassword()).
                submitLoginForUser().getCurrentLoggedUserName();

        Assert.assertEquals(actualUserName, customer1.getEmail(), "User name does not mach");


    }

}
