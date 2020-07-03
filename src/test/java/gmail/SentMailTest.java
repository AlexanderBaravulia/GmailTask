package gmail;

import conditions.TestConditions;
import model.Mail;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.DataProvider;
import steps.LoginSteps;
import steps.MailSteps;

public class SentMailTest extends TestConditions {

    private final User user = DataProvider.getUser("adasfaasdrf64");
    private final Mail mail = DataProvider.getMail(MESSAGE_SUBJECT);
    private final MailSteps mailSteps = new MailSteps();
    private final LoginSteps loginSteps = new LoginSteps();

    private static final String MESSAGE_SUBJECT = "Hello Java";

    @Test
    public void sentMailTest() {
        loginSteps.signIn(user);
        mailSteps.createNewMail(mail);
        Assert.assertTrue(mailSteps.isMessagePresentInSent(MESSAGE_SUBJECT), "The message is not present in sent mails.");
    }
}
