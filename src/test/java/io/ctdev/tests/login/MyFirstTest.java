package io.ctdev.tests.login;


import io.ctdev.tests.BaseTest;
import io.ctdev.framework.driver.WebDriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;
import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class MyFirstTest extends BaseTest {

    WebDriver driver;
    //WebDriver driver = new ChromeDriver();

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        System.out.println(driver);
        driver.get("https://www.google.com.ua");

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        wait.until(ExpectedConditions.titleContains("Go"));
        Assert.assertEquals(actualTitle, expectedTitle, "Tab tittle is not equal");

    }

    @Test
    public void searchWebElement() throws InterruptedException {
        driver.get("https://www.google.com.ua");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Customertimes");
        element.sendKeys(Keys.chord(Keys.ALT, "k"));

    }

//    @Test
//    public void cookieTest() {
//        driver.get("http://testworkspace.staging.bujapp.net");
//        driver.manage().addCookie(new Cookie("bujIdentityToken", "eyJraWQiOiJ2eEVSSElkQ0RTTkw4Q0NcL3cwWkp2YURleHFzdnNrbW96NlZESEpidm1lWT0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJmOWZmMWE0MC1lNWYwLTQ3NGItYWU4OC03NDcwNjYwYzUzY2UiLCJhdWQiOiI2cHBldHNhcGpxamYzMjgzcHJkc3FibWFyZiIsImV2ZW50X2lkIjoiNTk5MDhmMzktYTM1Ni00YmVmLTk3NzYtMjJlZDZhMzBmNmY3IiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2MDM0ODE1MTcsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTIuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0yX0NEcTNTemFJSCIsIm5pY2tuYW1lIjoiTmF0YWxpIiwiY29nbml0bzp1c2VybmFtZSI6ImY5ZmYxYTQwLWU1ZjAtNDc0Yi1hZTg4LTc0NzA2NjBjNTNjZSIsImV4cCI6MTYwMzU5OTY1MCwiaWF0IjoxNjAzNTk2MDUwLCJlbWFpbCI6Im5hdGFsaWlhLnNoYWtob3ZhQGN0ZGV2LmlvIiwiY3VzdG9tOnVzZXJJZCI6IjJkNWVhMDYyLTFjNWMtNGNjNi04ZmI0LWUyMDM5ZDMzMTIwYiJ9.BfpEr73crcPv3P3HNGp3f35aRO5paCSQg7wv1S3twOfQifV98WoWVWxvo06ZHQ1Y3AbZHHI6s9AvELRx0BS_-rGYV9iuAJsM7H_UQ42F-sxwNYcImGqFLFMfLijaj13kwczwHHwSfHYxjlQ55ElqQa15GhYszQmzmsNRihq1XY12IXztjUY4Bm0LmhqbATYbHQRY-34jNAK4IPH-p4kSwKkjRoBzHM2mZP7LAxBwVsSnl_urR1LTOEiic_rO2QAKHsHp5s4ufbTyHCAMZhMk6o41X-LaCuTfVnLTEmVZU7NPL44yw1F3Jv-Ytsy2GDL8JZ35egI3b9Hxctt8Ih4Uig"));
//        driver.manage().addCookie(new Cookie("bujRefreshToken", "eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.H92kkbjIAqbqm9kzRHMsFPJtVvZlI-IaYAEZzI01jRkO5cQsRIo5gQWoR4VDxHr-n2TRc73NNXVlpdYQ5ExZD8Z8AwWtVOKJg84_Cc2rjEmC_idN664CFg5EMauXpOowHULCFHvHOdx-jglupE2Ew0JM2lHqMv1pns8SGLpphGlap1HahJofZu65Rza1xvkhLIsNykypr3oMlYJJTYhO9Vvv0MZsR6uwp2jQrgBMJ4J-J1lyJy3jHaEphPANSYf5JeobOIyhWYOzdHDt2jqC9fM_o7p_HiQ7qdHIFInbywKx1lyhuJDY4FG4BERSXiVhPl60uWF0ZfEp6lqAaqw8WQ.l9i1qWi3SRkxxWIb.qCq_3DzIRG6m2p_C0VIxovWpqIAnQ0ooL1ruSpa4meFKjoZJm6s4WKTHhw2iw0nJ7lzuAYkKb-R_YSuaqDbKAIiQSTi4NFvmLVJbv3kEV4YStbiJ6UHkWhoVXG7mRERnEBLZjGztDvBghTOtWcnepcleLNwSpcn4IxPY97lXNKbSe_OKa4Niq57mZrqA_HzIc4MSOBnUESwqqN9n0SOJsx5yMSmfiIojNOOs5cTFrXBMqEqgaL8LDY-xrZM2nl_b2FVHwjZVsJV6RLEQV_2nT0tHuGw2Ye_j4bUGKu3PHdO2FMot10lopxMlCx1_vXrTKVodrnwFq08drHA2Jzvi7_f3vHlZNzko6Q4IobOW61gghz-aBfykObrMBAz57NsVRi6yz8oyf8jKvM49xO7-8218S3jOiui8Fr8Mw06lJu7yLDFK83c2EmVsVtuiaOMHtvcw5hgoH8mRKhhHyiRRFuxTMSXfx9k8t1NjEj6bHO-wchqxCkvjmDG9Ic3gWVvqTMUVLWZQYhrlrqfUtxi1Drtp3LFrgPjAiPGUf_sOkF7YEdoTkbmkI6GnAJXbkHPn9d7jXZxIjNGooWq-ri-4gMYQ002p4xvz02og1pwLI_I9tgNMxDadnFijfIqkG6Be62R_2LRpwmTDbjyxGRMAUKgE7fP9NTys2Ov3VX5SJXcwl4vTLqt5-GFiQKDzPnJhzvirt9Ri2LDOfDfVnYNHPenlNNqZAUBbe5Qsr6iyhSWB81JoqZ7wcDVxk4cbifZjBTt5tjigZtL4rm8-p9SAz3L-X5Dfb2KdiQpzuoF-3rtnJqBw5_fn461QeiLXgEY2SGNnYVjZL0ZYrsnz_c0Ree0H1rPgaP4JO8ZlSmLQWInjS5eQ-lT4gCz6SOMhRut3rWU-mtpbSYRKDQw1kv60a_lRamrWHtzlTqJRfGTR0_jOgiGQ7jnwV1WoWF59VRJEI19o3xtdVeETzBffyfkdbhGy2ZY5j0d9brDnwHsU02BiLoIH5O7mloyxgYczyteu3M5WOK1B1rSFvF6LAiQw1w7O-wVA91zenn8Yenalw1P0WOUUVQ2K7tNdjhAAtQ0y2A0pShN5GWxLueCRJtK_f4qFBQsmYihAZjaZLW4T9u-MvUC7NNL4faTbkwSlHtSiG5zpkhVmoZ_7qABI_nDurtHNnAqVef2X9-eVTTDOkOj0HOvMW9Vd12USIakMlX5hwd5dQAG_njsFlfqUODiy5wRD3nvlwjTuhI5frWQ3UxKFwo29oyuDgdanKGw_Zdofg0Q2byIrZUZDB4xFkVtXLM2CJkKyXW_z8SE0_46Vifdpa4OzLMKRx3vvD1I.tvRxV4prOZPpV5I_FE7A2g"));
//
//        driver.navigate().refresh();
//        getDriver().manage();
//
//        driver.manage().deleteAllCookies();
//        driver.navigate().refresh();
//        getDriver().manage();

//
//    }


    @BeforeClass
    public void beforeClass() {
//
//        WebDriverManager.chromedriver().setup();
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-fullscreen");
//
//        System.out.println("This is before class");
//        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        driver = getDriver();
    }

    @AfterClass
    public void afterClass() {
        WebDriverSingleton.closeDriver();
    }
}
