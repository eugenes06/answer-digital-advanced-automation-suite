package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static stepdefs.DriverHelper.driverInstance;
import static stepdefs.DriverHelper.navigate;

public class FormAuthenticationStepDef {
    private static final String ENDPOINT = "login";

    @Given("I enter the username {string}")
    public void i_enter_the_username(String username) {
        navigate(ENDPOINT);
        driverInstance().findElement(By.name("username")).sendKeys(username);
    }

    @Given("I enter the password {string}")
    public void i_enter_the_password(String password) {
        driverInstance().findElement(By.name("password")).sendKeys(password);
    }

    @When("I click Login")
    public void i_click_login() {
        driverInstance().findElement(By.className("fa-sign-in")).click();
    }

    @Then("the banner message will say {string}")
    public void the_banner_message_will_say(String expectedBannerMessage) {
        String actualBannerMessage = driverInstance().findElement(By.id("flash"))
                .getAttribute("innerHTML")
                .trim()
                .split("\n")[0];

        assertEquals(expectedBannerMessage, actualBannerMessage);
    }

    @Then("after I logout")
    public void after_i_logout() {
        driverInstance().findElement(By.className("icon-signout")).click();
    }
}
