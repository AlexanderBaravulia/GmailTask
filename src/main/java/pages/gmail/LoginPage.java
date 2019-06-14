package pages.gmail;

import actions.Actions;
import actions.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BasePage {

    public final static String PAGE_URL= "https://mail.google.com";

    @FindBy(xpath = "//input[@type='email']")
    private WebElement signInField;

    @FindBy (xpath = "//span[text()='Далее']")
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
}
