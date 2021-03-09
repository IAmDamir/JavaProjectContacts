package sample;

import java.time.LocalDateTime;

public class Person extends Contact {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;

    public Person(String firstName, String lastName, String number, String email, String birthDate, String gender) {
        this(firstName, lastName, number, email, birthDate, gender, LocalDateTime.now());
    }

    public Person(String firstName, String lastName, String number, String email,
                  String birthDate, String gender, LocalDateTime created){
        this.firstName = firstName;
        this.number = number;
        this.email = email;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.created = created;
        this.lastEdit = LocalDateTime.now();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }
}