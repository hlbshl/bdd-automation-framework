package pageObjects;

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

    private @FindBy(xpath = "//*[@id='origin']/div[2]/ul/li[1]/span[contains(text(), 'Istanbul Anatolia')]")
    WebElement firstElementOfOrigin;

    private @FindBy(xpath = "//*[@id='destination']/div[2]/ul/li[1]/span[contains(text(), 'Izmir')]")
    WebElement firstElementOfDestination;

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
        waitForElementAndPassValue(departure_station, departure, firstElementOfOrigin);
    }

    public void selectArrivalStation(String arrival) {
        waitForElementAndPassValue(arrival_station, arrival, firstElementOfDestination);
    }

    public void clickSearchButton() {
        waitForElementAndClick(search_button);
    }

    public void verifySearchResultsExist() {
        waitFor(searchResults);
    }

    public void waitForElementAndPassValue(WebElement element, String value, WebElement result) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOf(element));
        searchResult.sendKeys(value);
        wait.until(ExpectedConditions.visibilityOf(result));
        searchResult.sendKeys(Keys.ENTER);
    }
}
