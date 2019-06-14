package model;

import java.util.Objects;

public class User {

    private String name;
    private String emailAddress;
    private String password;

    public User(String name, String emailAddress, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public User (String emailAddress){
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(emailAddress, user.emailAddress) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress, password);
    }
}
