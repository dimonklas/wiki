package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import test_data.Urls;

import static com.codeborne.selenide.Selenide.open;
import static steps.CommonSteps.checkUrl;

public class WikipediaLanguagesTest extends BasePage {

    @DataProvider
    public Object[][] languageCodes() {
        return new Object[][]{
                {"EN"}, {"JA"}, {"RU"}, {"IT"}, {"PT"}, {"ES"}, {"DE"}, {"ZH"}, {"FR"}, {"PL"}
        };
    }

    @BeforeMethod
    public void openMainPage() {
        open(Urls.WIKIPEDIA_MAIN_PAGE.getUrl());
    }

    @Test(dataProvider = "languageCodes")
    public void checkLanguages(String languageCode) {
        wikipediaMainPage.pressButtonWithLanguage(languageCode);
        checkUrl("https://" + languageCode.toLowerCase() + ".wikipedia.org/wiki/", 5);
    }

}
