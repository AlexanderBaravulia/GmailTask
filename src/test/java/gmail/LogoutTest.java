package gmail;

import conditions.TestConditions;
import model.User;
import org.testng.annotations.Test;
import pages.gmail.LoginPage;
import service.DataProvider;
import steps.LoginSteps;
import steps.LogoutSteps;

public class LogoutTest extends TestConditions {
    private final User user = DataProvider.getUser("adasfaasdrf64");
    private LoginSteps loginSteps = new LoginSteps();
    private LogoutSteps logoutSteps = new LogoutSteps();

    @Test
    public void logoutWithExistingUserTest() {
        loginSteps.signIn(user);
        logoutSteps.logout();
        new LoginPage().validateTheUserLoginIsPresent(user);
    }
}
