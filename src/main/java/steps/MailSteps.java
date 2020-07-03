package steps;

import lombok.extern.slf4j.Slf4j;
import model.Mail;
import pages.gmail.MailPage;
import javax.annotation.Nonnull;


@Slf4j
public class MailSteps {

    private MailPage mailPage;

    public MailSteps(){
        mailPage = new MailPage();
    }

    public void createNewMail(@Nonnull final Mail mail){
        String recipientAddress = mail.getSentToAddress();
        log.info("Send new email to the {}", recipientAddress);
        mailPage.clickByButtonCreateMail()
                .setToAddress(recipientAddress)
                .setMailTitle(mail.getSubject())
                .setMailBody(mail.getMessage())
                .clickSentButton();
    }

    public boolean isMessagePresentInSent(@Nonnull final String subject){
        log.info("Check if the message with the subject {} is present in the sent mails list", subject);
        mailPage.clickSentMailLink();
        return mailPage.getSentMailSubjectList().stream().anyMatch(mailSubject -> mailSubject.contains(subject));
    }

}
