package steps;

import lombok.extern.slf4j.Slf4j;
import model.User;
import pages.gmail.LoginPage;
import javax.annotation.Nonnull;


@Slf4j
public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(){
        this.loginPage = new LoginPage();
    }

    public void signIn(@Nonnull final User user) {
        String userEmail = user.getEmailAddress();
        log.info("Open login page, enter user email {}, password *** and click submit button", userEmail);
        loginPage.open()
                .enterEmail(userEmail)
                .clickNextButton()
                .enterPassword(user.getPassword())
                .clickNextButton();
    }
}
