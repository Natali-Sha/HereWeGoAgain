package io.ctdev.tests.login;

import io.ctdev.tests.BaseTest;
import io.ctdev.tests.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.ctdev.tests.framework.driver.WebDriverSingleton.getDriver;

public class DataProvider_lesson_2 {

    /**
     * Unit test for simple App.
     */

    WebDriver driver;

    @DataProvider(name = "TestData")
    public Object[][] getData() {
        Object[][] data = new Object[2][2];
//        Object[][] data_2 = new Object[2][2];
//        Object[][] data_3 = new Object[2][2];

        data[0][0] = "login_1";
        data[0][1] = "password_1";
        data[1][0] = "login_2";
        data[1][1] = "password_2";
//
//        data[0][0] = "123456789";
//        data[0][1] = "surname_1";
//        data[1][0] = "987654321";
//        data[1][1] = "surname_2";
//
//        data[0][0] = "email_1";
//        data[0][1] = "repeat_password_1";
//        data[1][0] = "email_2";
//        data[1][1] = "repeat_password_2";

        return data;
//        return data_2;
//        return data_3;

    }

    @Test(dataProvider = "TestData")
//    public void register(String login, String surname, String phone, String email, String password, String repeatPassword) throws InterruptedException {
    public void register(String login, String password) throws InterruptedException {
        {
            driver.get("https://www.facebook.com/");
            Thread.sleep(10000);


            driver.findElement(By.id("name")).clear();
            driver.findElement(By.id("name")).sendKeys(login);

            driver.findElement(By.id("pass")).clear();
            driver.findElement(By.id("pass")).sendKeys(password);
            driver.findElement(By.id("login")).click();

            System.out.println("Test date - Name: " + login);
            System.out.println("Test date - Password: " + password);


            String expectedUrl = "https://www.facebook.com/user/";
            String actualUrl = driver.getCurrentUrl();

            System.out.println(driver.getCurrentUrl());

            Assert.assertEquals(expectedUrl,actualUrl,"FAIL( You are not registered");

            driver.close();
        }

    }

    @BeforeClass
    public void beforeClass() {


        driver = getDriver();


    }

    @AfterClass
    public void afterClass() {

        WebDriverSingleton.closeDriver();

    }
}

//            driver.findElement(By.id("surname")).clear();
//            driver.findElement(By.id("surname")).sendKeys(surname);
//
//            driver.findElement(By.id("phone")).clear();
//            driver.findElement(By.id("phone")).sendKeys(phone);
//
//            driver.findElement(By.id("email")).clear();
//            driver.findElement(By.id("email")).sendKeys(email);
// driver.findElement(By.id("repeat-password")).clear();
////            driver.findElement(By.id("repeat-password")).sendKeys(repeatPassword);
//
//
//         System.out.println("Test date - Name: " + login);
////            System.out.println("Test date - Surname: " + surname);
////            System.out.println("Test date - Phone: " + phone);
////            System.out.println("Test date - Email: " + email);
//         System.out.println("Test date - Password: " + password);
////            System.out.println("Test date - Repeat password : " + repeatPassword);
