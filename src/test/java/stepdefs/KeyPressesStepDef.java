package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static stepdefs.DriverHelper.driverInstance;
import static stepdefs.DriverHelper.navigate;

public class KeyPressesStepDef {
    private static final String ENDPOINT = "key_presses";

    @Given("I visit key presses page")
    public void i_visit_key_presses_page() {
        navigate(ENDPOINT);
    }

    @When("I press key {string}")
    public void i_press_key(String key) {
        WebElement inputBox = driverInstance().findElement(By.id("target"));
        inputBox.click();
        inputBox.sendKeys(getKeyPressed(key));
    }

    @Then("I can see the result key press cotaning {string}")
    public void i_can_see_the_result_key_press_cotaning(String key) {
        WebDriverWait wait = new WebDriverWait(driverInstance(), 10);

        wait.until((ExpectedCondition<Boolean>) driver -> (Boolean) (driverInstance().findElement(By.id("result"))
                .getText()
                .equals("You entered: " + key)));
    }

    private CharSequence getKeyPressed(String key) {
        switch (key) {
            case ("SHIFT"):
                return Keys.SHIFT;
            case ("CONTROL"):
                return Keys.CONTROL;
            case ("SPACE"):
                return Keys.SPACE;
            case ("HOME"):
                return Keys.HOME;
            default:
                return null;
        }
    }
}
