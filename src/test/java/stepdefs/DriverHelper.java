package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverHelper {
    private static final String BASE_URL = "http://the-internet.herokuapp.com/";
    private static final String CHROME_DRIVER_RESOURCE_SUB_PATH = "driver/chromedriver.exe";

    private static WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
    }

    @Before
    public void openBrowserBeforeScenario() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowserAfterScenario() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
        }
    }

    public static WebDriver driverInstance() {
        return driver;
    }

    public static JavascriptExecutor jsExecutorInstance() {
        return (JavascriptExecutor) driver;
    }

    public static void navigate(String endpoint) {
        driver.get(BASE_URL + endpoint);
    }

    private static String getChromeDriverPath() {
        ClassLoader classLoader = DriverHelper.class.getClassLoader();
        return classLoader.getResource(CHROME_DRIVER_RESOURCE_SUB_PATH).getFile();
    }
}
