package ssvv.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import ssvv.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagSearchTestData.csv")
public class SearchByKeywordStoryDdt {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.emag.ro/")
    public Pages pages;

    @Before
    public void initDriver(){
        webdriver.manage().window().maximize();
    }

    public String numeProdus;
    public String descriereProdus;

    @Qualifier
    public String getQualifier() {
        return numeProdus;
    }

    @Steps
    public EndUserSteps endUser;

    @Issue("#EMAG-1")
    @Test
    public void searchEmagByKeywordTestDDT() {
        endUser.is_the_home_page();
        endUser.search(getName());
        endUser.should_see_object(getDescription());
    }

    public String getName() {
        return numeProdus;
    }

    public void setName(String name) {
        this.numeProdus = name;
    }

    public String getDescription() {
        return descriereProdus;
    }

    public void setDefinition(String descriereProdus) {
        this.descriereProdus = descriereProdus;
    }


}
