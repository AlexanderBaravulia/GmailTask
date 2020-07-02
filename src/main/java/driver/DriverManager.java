package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utill.PropertyReader;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final int TIMEOUT = Integer.parseInt(PropertyReader.getConfigValue("timeout"));
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = PropertyReader.getConfigValue("browser");
            switch (browser) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "chrome": {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("lang=en-GB");
                    options.addArguments("disable-user-media-security");
                    options.addArguments("disable-web-security");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}


