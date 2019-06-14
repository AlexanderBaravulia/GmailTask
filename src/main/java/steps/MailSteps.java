package steps;

import model.Mail;
import pages.gmail.MailPage;
import java.util.List;

public class MailSteps {
    private MailPage mailPage;

    public MailSteps(){
        mailPage = new MailPage();
    }

    public void createNewMail(Mail mail){
        mailPage.clickByButtonCreateMail()
                .setToAddress(mail.getSentToAddress())
                .setMailTitle(mail.getSubject())
                .setMailBody(mail.getMessage()).clickSentButton();
    }

    public boolean isMessagePresentInSent(String subject){
        mailPage.clickSentMailLink();
        List<String> sentMailSubjects = mailPage.getSentMailSubjectList();
        for (String mailSubject : sentMailSubjects){
            if (mailSubject.contains(subject)){
                return true;
            }
        }
        return false;
    }

}
