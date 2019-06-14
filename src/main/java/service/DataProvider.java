package service;

import model.Mail;
import model.User;
import utill.JsonParser;

import java.io.File;
import java.util.List;

public class DataProvider {

    private static final String PATH_TO_JSON_USER =  "src" + File.separator + "main" + File.separator + "resources"
            + File.separator + "users.json";
    private static final String PATH_TO_JSON_MAIL =  "src" + File.separator + "main" + File.separator + "resources"
            + File.separator + "mail.json";

    public static User getUser(String userName) {
        List<User> userList = JsonParser.parseToList(PATH_TO_JSON_USER, User.class);
        for (User user: userList){
            if (user.getName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    public static Mail getMail(String subject) {
        List<Mail> mailList = JsonParser.parseToList(PATH_TO_JSON_MAIL, Mail.class);
        for (Mail mail: mailList){
            if (mail.getSubject().equals(subject)){
                return mail;
            }
        }
        return null;
    }
}
