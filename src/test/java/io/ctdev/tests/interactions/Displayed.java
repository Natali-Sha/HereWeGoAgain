package io.ctdev.tests.interactions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static io.ctdev.framework.driver.WebDriverSingleton.getDriver;

public class Displayed {

    @Test
    public void isDisplayedTest(){
        getDriver().get("http://output.jsbin.com/saqoca/2");

        String bodytext = getDriver().findElement(By.tagName("body")).getText();
        System.out.println(bodytext);

//        System.out.println("transparent: " + getDriver().findElement(By.id("transparent")).isDisplayed());
//        System.out.println("white: " + getDriver().findElement(By.id("white")).isDisplayed());
//        System.out.println("behind: " + getDriver().findElement(By.id("behind")).isDisplayed());
//        System.out.println("outside: " + getDriver().findElement(By.id("outside")).isDisplayed());
//        System.out.println("shifted: " + getDriver().findElement(By.id("shifted")).isDisplayed());

        getDriver().close();

    }
}
