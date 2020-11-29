package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static stepdefs.DriverHelper.driverInstance;
import static stepdefs.DriverHelper.navigate;

public class ShoppingBasketDeleteStepDef {
    private static final String FIRST_POPULAR_ITEM_BUTTON_XPATH = "//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]";
    private static final String CHECKOUT_BUTTON_XPATH = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a";
    private static final String FIRST_BASKET_ITEM_DELETE_BUTTON_XPATH = "//*[@id='1_1_0_0']/i";
    private static final String EMPTY_BASKET_BANNER_XPATH = "//*[@id='center_column']/p";

    @Given("I add an item to my basket")
    public void i_add_an_item_to_my_basket() {
        navigate("");
        driverInstance().findElement(By.xpath(FIRST_POPULAR_ITEM_BUTTON_XPATH)).click();
    }

    @When("I go to my basket page")
    public void i_go_to_my_basket_page() {
        driverInstance().findElement(By.xpath(CHECKOUT_BUTTON_XPATH)).click();
    }

    @Then("there is a delete button")
    public void there_is_a_delete_button() {
        // will fail implicit driver wait time if not present
        driverInstance().findElement(By.xpath(FIRST_BASKET_ITEM_DELETE_BUTTON_XPATH));
    }

    @Then("when I click it the item is removed from the basket")
    public void when_i_click_it_the_item_is_removed_from_the_basket() {
        driverInstance().findElement(By.xpath(FIRST_BASKET_ITEM_DELETE_BUTTON_XPATH)).click();
        waitUntilTheItemIsDeleted();
    }

    @Then("the banner will say {string}")
    public void the_banner_will_say(String expectedBannerMessage) {
        String actualBannerMessage = driverInstance().findElement(By.xpath(EMPTY_BASKET_BANNER_XPATH)).getText();

        assertEquals(expectedBannerMessage, actualBannerMessage);
    }

    private void waitUntilTheItemIsDeleted() {
        WebDriverWait wait = new WebDriverWait(driverInstance(), 3);
        wait.until((ExpectedCondition<Boolean>) driver -> {
            try {
                driverInstance().findElement(By.xpath(FIRST_BASKET_ITEM_DELETE_BUTTON_XPATH));
                return false; // item still present
            } catch (NoSuchElementException e) {
                return true;
            }
        });
    }
}
