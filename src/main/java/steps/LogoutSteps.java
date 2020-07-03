package steps;

import lombok.extern.slf4j.Slf4j;
import pages.gmail.LoginPage;
import pages.gmail.MailPage;


@Slf4j
public class LogoutSteps {

    private MailPage mailPage;

    public LogoutSteps(){
        this.mailPage = new MailPage();
    }

    public LoginPage logout() {
        log.info("Logout from the current account");
        mailPage.clickAccountLogo();
        mailPage.clickLogoutButton();
        return new LoginPage();
    }
}
