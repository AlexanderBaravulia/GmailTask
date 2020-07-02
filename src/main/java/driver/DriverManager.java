package driver;

import org.openqa.selenium.WebDriver;
import utill.PropertyReader;

import java.util.Optional;

public class DriverManager {

    private final static ThreadLocal<WebDriver> CACHE = ThreadLocal.withInitial(() -> null);

    private DriverManager() {
    }

    private static Optional<WebDriver> getFromCache()
    {
        return Optional.ofNullable(CACHE.get());
    }

    public static WebDriver get() {
        return getFromCache().orElseGet(() -> {
            WebDriverFactory factory = WebDriverFactory.getInstance(PropertyReader.getConfigValue("browser"));
            WebDriver driver = factory.create();
            CACHE.set(driver);
            return driver;
        });
    }

    public static void closeDriver()
    {
        getFromCache().ifPresent(driver -> {
            driver.quit();
            CACHE.remove();
        });
    }
}


