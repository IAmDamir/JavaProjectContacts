import java.time.LocalDateTime;
import java.util.Scanner;

class Organization extends Contact {
    String name;
    String address;
    String number;
    LocalDateTime created;
    LocalDateTime lastEdit;

    @Override
    public void add(Scanner scanner) {
        System.out.print("Enter the name:");
        name = scanner.nextLine();
        System.out.print("Enter the address:");
        address = scanner.nextLine().trim();
        System.out.print("Enter the number:");
        number = scanner.nextLine();
        if (!Contact.isValidNumber(number)) {
            System.out.print("Wrong number format!");
            number = "[no number]";
        }
        created = LocalDateTime.now().withNano(0).withSecond(0);
        lastEdit = LocalDateTime.now().withNano(0).withSecond(0);
    }

    @Override
    public void edit(Scanner scanner) {
        System.out.print("Select a field (name, address, number):");
        String userSelectionEdit = scanner.nextLine().trim();
        switch (userSelectionEdit) {
            case "name":
                System.out.print("Enter the name:");
                name = scanner.nextLine();
                break;
            case "address":
                System.out.print("Enter the address:");
                address = scanner.nextLine().trim();
                break;
            case "number":
                System.out.print("Enter the number:");
                number = scanner.nextLine();
                if (!Contact.isValidNumber(number)) {
                    System.out.println("Wrong number format!");
                    number = "[no number]";
                }
                break;
        }
        lastEdit = LocalDateTime.now().withNano(0).withSecond(0);
        System.out.println("Saved");
        info();
    }

    @Override
    public void info() {
        System.out.println("Organization name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Number: " + number);
        System.out.println("Time created: " + created);
        System.out.println("Time last edit: " + lastEdit);
    }

    @Override
    public boolean containsQuery(String query) {
        if (name.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (address.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else return number.toLowerCase().contains(query.toLowerCase());
    }

    @Override
    public String getName() {
        return name;
    }
}