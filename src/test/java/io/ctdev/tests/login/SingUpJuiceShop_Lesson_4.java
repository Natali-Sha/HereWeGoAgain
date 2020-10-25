package io.ctdev.tests.login;

import io.ctdev.tests.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static io.ctdev.tests.framework.driver.WebDriverSingleton.getDriver;

public class SingUpJuiceShop_Lesson_4 {

    private String userName = "natali7@ukr.net";
    private String pass = "09876543217";
    private String answer = "00.00.0000";

    @BeforeTest
    public void BeforeSingUp() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().get("http://3.18.213.48/#/");
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();

    }

    @AfterClass
    public void tearDown() {

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

        System.out.println("Selecting 'Privacy and Security'");
        getDriver().findElement(By.xpath("(.//*[@aria-label='Show Privacy and Security Menu'])[2]")).click();

        System.out.println("Selecting 'Request Data Erasure'");
        getDriver().findElement(By.xpath(".//*[@aria-label='Go to data subject page']")).click();

        System.out.println("Typing user email - " + userName);
        getDriver().findElement(By.id("email")).sendKeys(userName);

        System.out.println("Typing answer - " + answer);
        getDriver().findElement(By.id("securityAnswer")).sendKeys(answer);

        System.out.println("Clicking on 'Delete user data' button");
        getDriver().findElement(By.id("deleteUserButton")).click();

        System.out.println("Close driver");
        WebDriverSingleton.closeDriver();
    }

    @Test
    public void userIsAbleToLoginToShop() throws InterruptedException {

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

        Thread.sleep(4000);

        System.out.println("Clicking on Register button" );
        getDriver().findElement(By.id("registerButton")).click();

        Thread.sleep(15000);

        String getCurrentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(getCurrentUrl, "http://3.18.213.48/#/login", "Registration error" );

    }
}

//        newCustomerLink

//        System.out.println("Typing user email - " + userName);
//        getDriver().findElement(By.id("email")).sendKeys(userName);
//
//        System.out.println("Typing user password - 12345678");
//        getDriver().findElement(By.id("password")).sendKeys("12345678");
//
//        System.out.println("Clicking on Login button");
//        getDriver().findElement(By.id("loginButton")).click();
//
//        getDriver().findElement(By.id("navbarAccount")).click();
//
//        Thread.sleep(5000);
//
//        String actualUserName = getDriver().findElement(By.cssSelector("[aria-label='Go to user profile'] span")).getAttribute("innerText").trim();
//
////        Assert.assertEquals(actualUserName,userName, "User name does not mach");
//}
