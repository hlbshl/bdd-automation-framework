package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static utils.GlobalVariables.DEFAULT_EXPLICIT_TIMEOUT;

public class MainPage_PO extends Base_PO {
    private @FindBy(id = "language-modal-btn")
    WebElement language_selector;

    private @FindBy(xpath = "//a[@class='language ']/span[contains(text(),'English')][1]")
    WebElement english_language;

    private @FindBy(xpath = "//*[@id='language-modal-btn']/img")
    WebElement english_flag;

    private @FindBy(id = "origin-input")
    WebElement departure_station;

    private @FindBy(id = "destination-input")
    WebElement arrival_station;

    private @FindBy(id = "search-button")
    WebElement search_button;

    private @FindBy(id = "list")
    WebElement searchResults;

    public MainPage_PO() {
        super();
    }

    public void clickLanguageSelector() {
        waitForElementAndClick(language_selector);
    }

    public void selectEnglishLanguage() {
        waitForElementAndClick(english_language);
    }

    public void verifyEnglishLanguageSelected() {
        waitFor(english_flag);
        Assert.assertEquals(english_flag.getAttribute("alt"), "Flag Icon en-US");
    }

    public void selectDepartureStation(String departure) {
        waitForElementAndPassValue(departure_station, departure, "origin");
    }

    public void selectArrivalStation(String arrival) {
        waitForElementAndPassValue(arrival_station, arrival, "destination");
    }

    public void clickSearchButton() {
        waitForElementAndClick(search_button);
    }

    public void verifySearchResultsExist() {
        waitFor(searchResults);
    }

    public void waitForElementAndPassValue(WebElement element, String value, String direction) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOf(element));
        searchResult.sendKeys(value);
        By firstResult = By.xpath("//*[@id='" + direction + "']/div[2]/ul/li[1]/span[contains(text(), '" + value + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResult));
        searchResult.sendKeys(Keys.ENTER);
    }
}
