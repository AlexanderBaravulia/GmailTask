package pages.gmail;

import actions.Actions;
import actions.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class MailPage extends BasePage {

    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#inbox']")
    private WebElement inboxMailLink;

    @FindBy (xpath = "//div[text()='Написать']")
    private WebElement buttonCreateMail;

    @FindBy (xpath = "//div[@data-tooltip='Отправленные']")
    private WebElement sentMailLink;

    @FindBy(xpath = "//tbody/tr[.//div[text()='Кому: ']]/td[6]")
    private List<WebElement> sentMailSubjectList;

    public boolean isInboxMailLinkPresent(){
        return Actions.isDisplayed(inboxMailLink);
    }

    public NewMessagePage clickByButtonCreateMail(){
        Actions.click(buttonCreateMail);
        return new NewMessagePage();
    }

    public MailPage clickSentMailLink(){
        Actions.click(sentMailLink);
        return this;
    }

    public List<String> getSentMailSubjectList(){
        List<String> subjectList = new ArrayList<>();
        for (WebElement element: sentMailSubjectList){
            subjectList.add(element.getText());
        }
        return subjectList;
    }


}
