package pages;

import driver.DriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;


@Slf4j
public class BasePage {

    protected WebDriver driver;

    protected BasePage(){
        this.driver = DriverManager.get();
        PageFactory.initElements(driver, this);
    }

    protected void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    protected void openNewTab() {
        log.info("Open new browser tab");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    protected void goToFirstTab() {
        log.info("Switch to the first opened tab");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

}
