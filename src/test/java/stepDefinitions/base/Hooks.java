package stepDefinitions.base;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;

import static driver.DriverFactory.cleanUpDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {

    static boolean firstSession = true;

    @Before
    public void setup() {
        if (firstSession) {
            getDriver();
            firstSession = false;
        }
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String time = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", time);
        }
    }

    @AfterAll
    public static void after_all() {
        cleanUpDriver();
    }
}
