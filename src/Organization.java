import java.time.LocalDateTime;

public class Organization extends Contact {
    private String name;
    private String address;

    public Organization(String name, String number, String email, String address){
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
        this.created = LocalDateTime.now();
        this.lastEdit = LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}