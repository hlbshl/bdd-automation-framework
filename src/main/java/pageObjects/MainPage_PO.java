package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage_PO extends Base_PO {
    private @FindBy(id = "language-modal-btn")
    WebElement language_selector;

    private @FindBy(xpath = "//a[@class='language ']/span[contains(text(),'English')][1]")
    WebElement english_language;

    private @FindBy(xpath = "//*[@id='language-modal-btn']/img")
    WebElement english_flag;

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
}
