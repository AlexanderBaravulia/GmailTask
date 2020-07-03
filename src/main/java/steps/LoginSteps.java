package steps;

import model.User;
import pages.gmail.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(){
        this.loginPage = new LoginPage();
    }

    public void signIn(User user) {
        loginPage.open()
                .enterEmail(user.getEmailAddress())
                .clickNextButton()
                .enterPassword(user.getPassword())
                .clickNextButton();
    }
}
