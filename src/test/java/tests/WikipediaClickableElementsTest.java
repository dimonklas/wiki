package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import test_data.Urls;

import static com.codeborne.selenide.Selenide.open;
import static steps.CommonSteps.clickTheElementByTagAndText;

public class WikipediaClickableElementsTest extends BasePage {

    @BeforeMethod
    public void openMainPage() {
        open(Urls.WIKIPEDIA_MAIN_PAGE.getUrl());
    }

    @Test
    public void checkClickableElements() {
        wikipediaMainPage.pressButtonWithLanguage("RU");
        clickTheElementByTagAndText("span", "Содержание");
        clickTheElementByTagAndText("span", "Случайная статья");
        clickTheElementByTagAndText("span", "Форум");
        clickTheElementByTagAndText("span", "Заглавная страница");
        clickTheElementByTagAndText("span", "Обсуждение", 2);
    }

}
