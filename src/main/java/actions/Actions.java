package actions;

import driver.DriverManager;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
@UtilityClass
public class Actions {

    public static void click(WebElement webElement) {
        log.info("Click on {}", webElement);
        Waiter.waitElementVisible(DriverManager.get(), webElement);
        webElement.click();
    }

    public static void type(WebElement webElement, String text) {
        log.info("Typing text {} to {})", text, webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static boolean isDisplayed(WebElement webElement) {
        boolean displayed = webElement.isDisplayed();
        log.info("Element {} is {}.", webElement, displayed ? "displayed" : "not displayed");
        return displayed;
    }
}
