package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public enum WebDriverFactory {

    CHROME {
        @Override
        public WebDriver create() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    FIREFOX {
        @Override
        public WebDriver create() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    };

    public abstract WebDriver create();

    public static WebDriverFactory getInstance(String browser) {
        return WebDriverFactory.valueOf(browser.toUpperCase());
    }
}