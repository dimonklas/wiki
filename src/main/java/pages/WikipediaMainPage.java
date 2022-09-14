package pages;

import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static logger.CustomLogger.logger;

public class WikipediaMainPage {

    @Step
    public void pressButtonWithLanguage(String countryCode) {
        $(byXpath("//a[@class='link-box']//strong[text()='"
                + transformCountryCodeToLanguage(countryCode) + "']"))
                .click();
        logger.info("ok");
    }

    @Step
    public String transformCountryCodeToLanguage(String countryCode) {
        switch (countryCode) {
            case "EN":
                return "English";
            case "JA":
                return "日本語";
            case "RU":
                return "Русский";
            case "IT":
                return "Italiano";
            case "PT":
                return "Português";
            case "ES":
                return "Español";
            case "DE":
                return "Deutsch";
            case "ZH":
                return "中文";
            case "FR":
                return "Français";
            case "PL":
                return "Polski";
            default:
                Assert.fail("Country code " + countryCode + " not found!");
        }
        return null;
    }

}
