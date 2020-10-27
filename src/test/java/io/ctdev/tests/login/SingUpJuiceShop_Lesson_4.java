package io.ctdev.tests.login;

import io.ctdev.tests.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import static io.ctdev.tests.framework.driver.WebDriverSingleton.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class SingUpJuiceShop_Lesson_4 {

    private String userName = "natali13@ukr.net";
    private String pass = "09876543217";
    private String answer = "00.00.0000";

    @BeforeClass
    public void beforeSingUp() {
        //getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//       WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 5, 1000);
        WebDriverWait wait = new WebDriverWait(getDriver(),5)
                ;
        getDriver().get("http://3.18.213.48/#/");



        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class*='close-dialog']")));


        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();

    }

    @AfterClass
    public void tearDown() {

        WebDriverWait wait = new WebDriverWait(getDriver(),5);

        System.out.println("After Class: Login after sing-up");

        getDriver().findElement(By.id("email")).clear();
        System.out.println("Typing user email - " + userName);
        getDriver().findElement(By.id("email")).sendKeys(userName);

        getDriver().findElement(By.id("password")).clear();
        System.out.println("Typing user password - " + pass);
        getDriver().findElement(By.id("password")).sendKeys(pass);

        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("loginButton")).click();

        System.out.println("Deleting an account");

        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(By.id("navbarAccount"));
        element.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(.//*[@aria-label='Show Privacy and Security Menu'])[2]")));

        System.out.println("Selecting 'Privacy and Security'");
        getDriver().findElement(By.xpath("(.//*[@aria-label='Show Privacy and Security Menu'])[2]")).click();

        System.out.println("Selecting 'Request Data Erasure'");
        getDriver().findElement(By.xpath(".//*[@aria-label='Go to data subject page']")).click();

        System.out.println("Typing user email - " + userName);
        getDriver().findElement(By.id("email")).sendKeys(userName);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("securityAnswer")));

        System.out.println("Typing answer - " + answer);
        getDriver().findElement(By.id("securityAnswer")).sendKeys(answer);

        System.out.println("Clicking on 'Delete user data' button");
        getDriver().findElement(By.id("deleteUserButton")).click();

        System.out.println("Close driver");
        WebDriverSingleton.closeDriver();
    }

    @Test
    public void userIsAbleToLoginToShop() throws InterruptedException {



        WebDriverWait wait = new WebDriverWait(getDriver(),7);
//alertIsPresent();
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        System.out.println("Clicking on Account button");
        WebElement element = getDriver().findElement(By.id("navbarAccount"));
        element.click();

        System.out.println("Clicking on Login button");
        getDriver().findElement(By.id("navbarLoginButton")).click();

        System.out.println("Clicking on 'Not yet customer?' link");
        getDriver().findElement(By.id("newCustomerLink")).click();

        System.out.println("Typing user email - " + userName);
        getDriver().findElement(By.id("emailControl")).sendKeys(userName);

        System.out.println("Switch on 'Show password advice' toggle  - ON");
        getDriver().findElement(By.xpath(".//*[@class='mat-slide-toggle-thumb']")).click();

        System.out.println("Typing user password - " + pass);
        getDriver().findElement(By.id("passwordControl")).sendKeys(pass);

        System.out.println("Repeat user password - " + pass);
        getDriver().findElement(By.id("repeatPasswordControl")).sendKeys(pass);

        System.out.println("Switch on 'Show password advice' toggle - OFF");
        getDriver().findElement(By.xpath(".//*[@class='mat-slide-toggle-thumb']")).click();

        System.out.println("Clicking on Security Question");
        getDriver().findElement(By.xpath(".//*[@name='securityQuestion']")).click();

        System.out.println("Selecting Security Question ");
        getDriver().findElement(By.xpath(".//*[@id='mat-option-5']")).click();

        System.out.println("Typing answer - " + answer);
        getDriver().findElement(By.id("securityAnswerControl")).sendKeys(answer);

      //  force page reload

        System.out.println("Clicking on Register button");


        WebElement registerButton = getDriver().findElement(By.id("registerButton"));
       // getDriver().findElement(By.id("registerButton")).click();

        registerButton.click();




        //This will scroll the web page till end.
//        js.executeScript("window.scrollBy(0,100)");
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  //      wait.until(ExpectedConditions.stalenessOf());

//        WebElement registerButton = getDriver().findElement(By.id("registerButton"));
//        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(getDriver().findElement(By.xpath(".//*[@href='#/login']")));
//        registerButton.click();


//        wait.until(ExpectedConditions.urlToBe("http://3.18.213.48/#/login"));

        String getCurrentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(getCurrentUrl, "http://3.18.213.48/#/login", "Registration error");

    }
}


