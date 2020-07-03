package steps;

import model.User;
import pages.gmail.LoginPage;
import pages.gmail.MailPage;

public class LogoutSteps {

    private LoginPage loginPage;
    private MailPage mailPage;

    public LogoutSteps(){
        this.loginPage = new LoginPage();
        this.mailPage = new MailPage();
    }

    public void logout() {
        mailPage.clickAccountLogo();
        mailPage.clickLogoutButton();
    }
}
