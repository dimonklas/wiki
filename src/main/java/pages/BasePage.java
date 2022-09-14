package pages;

import config.RunnerConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BasePage {
    private final RunnerConfig config = new RunnerConfig();
    public WikipediaMainPage wikipediaMainPage = new WikipediaMainPage();

    @BeforeClass
    @Parameters({"browser", "browserVersion"})
    public void setUp(@Optional("Chrome") String browser, @Optional String browserVersion) throws MalformedURLException {
        config.setUpConfig(browser, browserVersion);
    }
}
