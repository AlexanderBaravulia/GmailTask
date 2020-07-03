package model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Mail {

    private String subject;
    @NonNull
    private String sentToAddress;
    private String message;

}
