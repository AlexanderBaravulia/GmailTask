package actions;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Actions {
    private static final Logger LOGGER = LoggerFactory.getLogger(Actions.class);

    public static void click(WebElement webElement) {
        LOGGER.info("Click on {}", webElement);
        webElement.click();
    }

    public static void type(WebElement webElement, String text) {
        LOGGER.info("Typing text {} to {})", text, webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static boolean isDisplayed(WebElement webElement) {
        boolean displayed = webElement.isDisplayed();
        LOGGER.info("Element {} is {}.", webElement, displayed ? "displayed" : "not displayed");
        return displayed;
    }
}
