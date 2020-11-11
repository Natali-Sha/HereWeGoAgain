package io.ctdev.cucumber.stepdef;

import io.ctdev.cucumber.pages.AddToBasketObject;
import io.ctdev.framework.driver.WebDriverSingleton;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddToBasketStepdefs {

    private AddToBasketObject addToBasket = new AddToBasketObject(WebDriverSingleton.getDriver());

    @When("user search a category with product")
    public void userSearchACategoryWithProduct() {
        addToBasket.openPage();
    }

    @When("user looking for {string}")
    public void userFindAProduct(String request) {
        addToBasket.inputInTheSearchField(request);
        addToBasket.clickOnTheSearchButton();

    }

    @When("user adds product to basket")
    public void userAddsProductToBasket() {
        addToBasket.addProductToBasket();
        addToBasket.clickOnBasketButton();
    }


    @Then("product should be {string} in the basket")
    public void productShouldBeInTheBasket(String expectedProductName) {
        String productNameB = addToBasket.productName();
        Assert.assertEquals(productNameB, expectedProductName, "Генератор бензиновый RZTK G 3500E \"- The title is invalid.");

    }
}
