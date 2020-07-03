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

    @FindBy(xpath = "//div[text()='Написать']")
    private WebElement buttonCreateMail;

    @FindBy(xpath = "//div[@data-tooltip='Отправленные']")
    private WebElement sentMailLink;

    @FindBy(xpath = "//img[@class='gb_Ia gbii']")
    private WebElement accountLogo;

    @FindBy(xpath = "//a[@class='gb_Jb gb_kg gb_sg gb_5e gb_5c']")
    private WebElement logoutButton;

    @FindBy(xpath = "//tbody/tr[.//div[text()='Кому: ']]/td[6]")
    private List<WebElement> sentMailSubjectList;

    public NewMessagePage clickByButtonCreateMail() {
        Actions.click(buttonCreateMail);
        return new NewMessagePage();
    }

    public MailPage clickSentMailLink() {
        Actions.click(sentMailLink);
        return this;
    }

    public List<String> getSentMailSubjectList() {
        List<String> subjectList = new ArrayList<>();
        for (WebElement element : sentMailSubjectList) {
            subjectList.add(element.getText());
        }
        return subjectList;
    }

    public boolean validateTheInboxMaiLinkIsPresent() {
        Waiter.waitElementVisible(driver, inboxMailLink);
        return Actions.isDisplayed(inboxMailLink);
    }

    public MailPage clickAccountLogo() {
        Actions.click(accountLogo);
        return this;
    }

    public LoginPage clickLogoutButton() {
        Actions.click(logoutButton);
        return new LoginPage();
    }
}
