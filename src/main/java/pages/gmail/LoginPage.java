package pages.gmail;

import actions.Actions;
import actions.Waiter;
import driver.DriverManager;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class LoginPage extends BasePage {

    public final static String PAGE_URL= "https://mail.google.com";
    private final static String EMAIL_XPATH_PATTERN = "//div[contains(@data-email, '%s')]";

    @FindBy(xpath = "//input[@type='email']")
    private WebElement signInField;

    @FindBy (xpath = "//span[@class='CwaK9']/span")
    private WebElement buttonNext;

    @FindBy (xpath = "//input[@type='password']")
    private WebElement passwordField;

    public LoginPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    public LoginPage enterEmail(String email){
        Actions.type(signInField, email);
        return this;
    }

    public LoginPage clickNextButton(){
        Waiter.waitElementVisible(driver, buttonNext);
        Actions.click(buttonNext);
        return this;
    }

    public LoginPage enterPassword(String password){
        Waiter.waitElementVisible(driver, passwordField);
        Actions.type(passwordField, password);
        return this;
    }

    public void validateTheUserLoginIsPresent(User user) {
        WebElement userLogin = DriverManager.get().findElement(By.xpath(String.format(EMAIL_XPATH_PATTERN, user.getEmailAddress())));
        Assert.assertTrue(userLogin.isDisplayed(), "The user login is not displayed");
    }
}
