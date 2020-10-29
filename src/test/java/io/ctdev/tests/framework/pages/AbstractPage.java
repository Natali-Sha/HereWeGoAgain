package io.ctdev.tests.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int TIME_OUT = 10;

    public AbstractPage (WebDriver driver){
        this.driver = driver;
    }

    public abstract void openPage();

}
