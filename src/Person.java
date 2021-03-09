import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Person extends Contact {
    String name;
    String surname;
    String birthDate;
    String gender;
    String number;
    LocalDateTime created;
    LocalDateTime lastEdit;

    Pattern datePattern = Pattern.compile("[0-9]+");

    public boolean isValidDate(String date){
        String[] birth = date.split("-");
        for (String s : birth) {
            Matcher ifDate = datePattern.matcher(s);
            if (!ifDate.matches()) {
                return false;
            }
        }
        if (birth.length == 3) {
            boolean year = Integer.parseInt(birth[0]) > 0;
            boolean month = Integer.parseInt(birth[1]) > 0 && Integer.parseInt(birth[1]) < 13;
            boolean day = Integer.parseInt(birth[2]) > 0 && Integer.parseInt(birth[2]) < 32;
            return year && month && day;
        }
        return false;
    }

    @Override
    public void add(Scanner scanner) {
        System.out.print("Enter the name:");
        name = scanner.nextLine().trim();
        System.out.print("Enter the surname:");
        surname = scanner.nextLine().trim();
        System.out.print("Enter the birth date:");
        String newDate = scanner.nextLine().trim();
        if (isValidDate(newDate)){
            birthDate = newDate;
        } else{
            System.out.println("Bad birth date!");
            birthDate = "[no data]";
        }
        System.out.print("Enter the gender (M, F):");
        gender = scanner.nextLine().trim();
        if (!("M".equals(gender) || "F".equals(gender))) {
            System.out.println("Bad gender!");
            gender = "[no data]";
        }
        System.out.print("Enter the number:");
        number = scanner.nextLine();
        if (!Contact.isValidNumber(number)) {
            System.out.println("Wrong number format!");
            number = "[no number]";
        }
        created = LocalDateTime.now().withNano(0).withSecond(0);
        lastEdit = LocalDateTime.now().withNano(0).withSecond(0);
    }

    @Override
    public void edit(Scanner scanner) {
        System.out.print("Select a field (name, surname, birth, gender, number):");
        String userSelectionEdit = scanner.nextLine().trim();
        switch (userSelectionEdit) {
            case "name":
                System.out.print("Enter name:");
                name = scanner.nextLine().trim();
                break;
            case "surname":
                System.out.print("Enter surname:");
                surname = scanner.nextLine().trim();
                break;
            case "birth":
                System.out.print("Enter birth date:");
                String newDate = scanner.nextLine().trim();
                if (isValidDate(newDate)){
                    birthDate = newDate;
                } else {
                    System.out.println("Bad birth date!");
                    birthDate = "[no data]";
                }
                break;
            case "gender":
                System.out.print("Enter the gender (M, F):");
                gender = scanner.nextLine().trim();
                if (!("M".equals(gender) || "F".equals(gender))) {
                    System.out.println("Bad gender!");
                    gender = "[no data]";
                }
                break;
            case "number":
                System.out.print("Enter the number:");
                number = scanner.nextLine();
                if (!isValidNumber(number)) {
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
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Birth date: " + birthDate);
        System.out.println("Gender: " + gender);
        System.out.println("Number: " + number);
        System.out.println("Time created: " + created);
        System.out.println("Time last edit: " + lastEdit);
    }

    @Override
    public boolean containsQuery(String query) {
        if (name.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (surname.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (birthDate.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (gender.toLowerCase().contains(query.toLowerCase())){
            return true;
        } else if (number.toLowerCase().contains(query.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return String.format("%s %s", name, surname);
    }
}