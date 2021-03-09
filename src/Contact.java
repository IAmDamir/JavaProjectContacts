package sample;

import java.io.Serializable;
import java.time.LocalDateTime;

abstract class Contact implements Serializable {
    protected String number;
    protected String email;
    protected LocalDateTime created;
    protected LocalDateTime lastEdit;

    public String getNumber(){
        return number;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }
}