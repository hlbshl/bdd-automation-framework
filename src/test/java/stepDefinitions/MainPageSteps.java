package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MainPage_PO;

import static utils.GlobalVariables.OBILET_HOMEPAGE_URL;

public class MainPageSteps {
    private MainPage_PO mainPage_po;

    public MainPageSteps(MainPage_PO mainPage_po) {
        this.mainPage_po = mainPage_po;
    }

    @Given("actor navigates to Obilet main page")
    public void actor_navigates_to_obilet_main_page() {
        mainPage_po.navigate_to_URL(OBILET_HOMEPAGE_URL);
    }

    @When("actor clicks on language selector")
    public void actor_clicks_on_language_selector() {
        mainPage_po.clickLanguageSelector();
    }

    @When("actor selects English language")
    public void actor_selects_english_language() {
        mainPage_po.selectEnglishLanguage();
    }

    @When("actor searches for Istanbul Anatolia depurture station")
    public void actor_searches_for_istanbul_anatolia_depurture_station() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("actor searches for Izmir arrival station")
    public void actor_searches_for_izmir_arrival_station() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("actor selects today date")
    public void actor_selects_today_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("actor clicks on search button")
    public void actor_clicks_on_search_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("actor verifies page is displayed in English")
    public void actor_verifies_page_displayed_in_english() {
       mainPage_po.verifyEnglishLanguageSelected();
    }

    @Then("actor verifies search results are present")
    public void actor_verifies_search_results_are_present() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
