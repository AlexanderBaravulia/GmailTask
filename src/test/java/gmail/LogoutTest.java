package gmail;

import conditions.TestConditions;
import model.User;
import org.testng.annotations.Test;
import pages.gmail.LoginPage;
import service.DataProvider;
import steps.LoginSteps;
import steps.LogoutSteps;

public class LogoutTest extends TestConditions {

    private final User user = DataProvider.getUser("account1");
    private final LoginSteps loginSteps = new LoginSteps();
    private final LogoutSteps logoutSteps = new LogoutSteps();

    @Test
    public void logoutWithExistingUserTest() {
        loginSteps.signIn(user);
        LoginPage loginPage = logoutSteps.logout();
        loginPage.validateTheUserLoginIsPresent(user);
    }
}
