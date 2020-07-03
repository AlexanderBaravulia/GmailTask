package model;

import lombok.Data;
import lombok.NonNull;


@Data
public class User {

    @NonNull
    private String name;
    private String emailAddress;
    @NonNull
    private String password;

}
