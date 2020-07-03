package service;

import lombok.experimental.UtilityClass;
import model.Mail;
import model.User;
import utill.JsonParser;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.util.List;


@UtilityClass
public class DataProvider {

    private static final String PATH_TO_JSON_USER = "src" + File.separator + "main" + File.separator + "resources"
            + File.separator + "users.json";
    private static final String PATH_TO_JSON_MAIL = "src" + File.separator + "main" + File.separator + "resources"
            + File.separator + "mail.json";

    @Nullable
    public static User getUser(@Nonnull final String userName) {
        List<User> userList = JsonParser.parseToList(PATH_TO_JSON_USER, User.class);
        return userList.stream().filter(user -> user.getName().equals(userName)).findFirst().orElse(null);
    }

    @Nullable
    public static Mail getMail(@Nonnull final String subject) {
        List<Mail> mailList = JsonParser.parseToList(PATH_TO_JSON_MAIL, Mail.class);
        return mailList.stream().filter(mail -> mail.getSubject().equals(subject)).findFirst().orElse(null);
    }
}
