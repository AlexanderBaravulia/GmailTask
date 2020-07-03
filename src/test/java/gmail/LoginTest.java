package gmail;

import conditions.TestConditions;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gmail.MailPage;
import service.DataProvider;
import steps.LoginSteps;


public class LoginTest extends TestConditions {

    private final User user = DataProvider.getUser("account1");
    private final LoginSteps loginSteps = new LoginSteps();

    @Test
    public void loginWithExistingUserTest() {
        loginSteps.signIn(user);
        Assert.assertTrue(new MailPage().validateTheInboxMaiLinkIsPresent(), "The user is not logged in");
    }
}
