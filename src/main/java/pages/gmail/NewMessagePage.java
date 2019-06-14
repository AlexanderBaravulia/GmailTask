package pages.gmail;

import actions.Actions;
import actions.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class NewMessagePage extends BasePage {

    @FindBy (name = "to")
    private WebElement fieldTo;

    @FindBy (name = "subjectbox")
    private WebElement fieldTitle;

    @FindBy (xpath = "//div[@role='textbox']")
    private WebElement messageBody;

    @FindBy (xpath = "//div[text()='Отправить']")
    private WebElement buttonSent;

    public NewMessagePage setToAddress(String adress){
        Waiter.waitElementVisible(driver, fieldTo);
        Actions.type(fieldTo, adress);
        return this;
    }

    public NewMessagePage setMailTitle(String title){
        Actions.type(fieldTitle, title);
        return this;
    }

    public NewMessagePage setMailBody(String mailBody){
        Actions.type(messageBody, mailBody);
        return this;
    }

    public MailPage clickSentButton(){
        Actions.click(buttonSent);
        return new MailPage();
    }

}
