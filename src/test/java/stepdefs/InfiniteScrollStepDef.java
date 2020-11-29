package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static stepdefs.DriverHelper.*;

public class InfiniteScrollStepDef {
    private static final String ENDPOINT = "infinite_scroll";
    private static final String JS_SCROLL_SCRIPT = "window.scrollTo(0, %s)";

    @Given("I visit infinite scroll page")
    public void i_visit_infinite_scroll_page() {
        navigate(ENDPOINT);
    }

    @When("I scroll down to the bottom {int} times")
    public void i_scroll_down_to_the_bottom_times(Integer scrollNumberOfTimes) throws InterruptedException {
        for (int i = 0; i < scrollNumberOfTimes; i++) {
            TimeUnit.MILLISECONDS.sleep(300);
            jsExecutorInstance().executeScript(scrollToBottomJsScript());
        }
    }

    @Then("I scroll up")
    public void i_scroll_up() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(300);
        jsExecutorInstance().executeScript(scrollToTopJsScript());
    }

    @And("the top title text will say {string}")
    public void the_top_title_text_will_say(String expectedTitle) {
        String actualTitle = driverInstance().findElement(By.xpath("//div[@id='content']/div[@class='example']/h3")).getText();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    private String scrollToBottomJsScript() {
        return String.format(JS_SCROLL_SCRIPT, "document.body.scrollHeight");
    }

    private String scrollToTopJsScript() {
        return String.format(JS_SCROLL_SCRIPT, 0);
    }
}
