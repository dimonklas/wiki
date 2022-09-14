package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import logger.CustomLogger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;

public class RunnerConfig {

    @Step
    public void setUpConfig(String browser, String browserVersion) throws MalformedURLException {
//        boolean modeDebug = true;
//
//        Configuration.pageLoadTimeout = 20000;
//        Configuration.timeout = 10000;
//        Configuration.downloadsFolder = "target/build/downloads";
//        Configuration.reportsFolder = "target/screenshots";
//        Configuration.browser = browser;
//        if (browserVersion != null) {
//            Configuration.browserVersion = browserVersion;
//        }
//        if (!modeDebug) {
//            Configuration.remote = "http://localhost:4444/wd/hub";
//            Configuration.browserCapabilities.setCapability("enableVNC", false);
//            Configuration.browserCapabilities.setCapability("enableVideo", false);
//        }
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(true)
//                .savePageSource(true));
//        CustomLogger.logger.info("ok");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized"); // open Browser in maximized mode
//        options.addArguments("disable-infobars"); // disabling infobars
//        options.addArguments("--disable-extensions"); // disabling extensions
//        options.addArguments("--disable-gpu"); // applicable to windows os only
//        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//        options.addArguments("--no-sandbox"); // Bypass OS security model
////        options.addArguments("--headless");
//
//        Configuration.browserCapabilities.merge(options);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");

        DesiredCapabilities capability = DesiredCapabilities.chrome();
        if (Boolean.parseBoolean(System.getProperty("enableVideo"))) {
            String testName = Reporter.getCurrentTestResult().getName();
            capability.setCapability("enableVideo", true);
            capability.setCapability("videoName", testName + "_[Chrome]");
        }
        capability.setPlatform(Platform.valueOf("LINUX"));
        capability.setBrowserName("chrome");
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        capability.setCapability("enableVnc", true);

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        WebDriverRunner.setWebDriver(driver);
    }
}
