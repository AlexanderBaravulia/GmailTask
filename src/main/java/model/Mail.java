package model;

public class Mail {

    private String subject;
    private String sentToAddress;
    private String message;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSentToAddress() {
        return sentToAddress;
    }

    public void setSentToAddress(String sentToAddress) {
        this.sentToAddress = sentToAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
