package gmail;

import conditions.TestConditions;
import model.Mail;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.DataProvider;
import steps.LoginSteps;
import steps.MailSteps;

public class SentMailTest extends TestConditions {

    private final User user = DataProvider.getUser("alex");
    private final Mail mail = DataProvider.getMail(MESSAGE_SUBJECT);
    private final MailSteps mailSteps = new MailSteps();

    private static final String MESSAGE_SUBJECT = "Hello";

    @BeforeMethod
    public void before(){
        new LoginSteps().signIn(user);
    }

    @Test
    public void sentMailTest(){
        mailSteps.createNewMail(mail);
        Assert.assertTrue(mailSteps.isMessagePresentInSent(MESSAGE_SUBJECT), "The message is not present in sent mails.");
    }
}
