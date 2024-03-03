package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.GlobalVariables.DEFAULT_EXPLICIT_TIMEOUT;

public class Base_PO {

    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigate_to_URL(String url) {
        getDriver().get(url);
    }

    public void waitForElementAndPassValue(By by, String value) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(value);
        getDriver().wait(5000);
        getDriver().findElement(by).sendKeys(Keys.ENTER);
    }

    public void waitForElementAndPassValue(WebElement element, String value) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOf(element));
        searchResult.sendKeys(value);

// temporary mock to wait until results appear. Will be replaced with a better solution
        Thread.sleep(5000);
        searchResult.sendKeys(Keys.ENTER);
    }

    public void waitForElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitForElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
