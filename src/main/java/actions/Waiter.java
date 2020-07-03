package actions;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utill.PropertyReader;


@UtilityClass
public class Waiter {

    private static final int WAIT_TIME = Integer.parseInt(PropertyReader.getConfigValue("timeout"));

    public static void waitElementVisible(WebDriver driver, WebElement webElement){
        new WebDriverWait(driver, WAIT_TIME)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}
