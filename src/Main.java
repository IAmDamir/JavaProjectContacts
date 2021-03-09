import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        Contacts contacts;
        contacts = new Contacts();
        Scanner scanner = new Scanner(System.in);
        String currentAction;

        while (!exit) {
            currentAction = "[menu]";
            System.out.printf("%s Enter action (add, list, search, count, exit):", currentAction);
            switch (scanner.nextLine().trim()) {
                case "exit" -> exit = true;
                case "add" -> contacts.add(scanner);
                case "count" -> contacts.count();
                case "list" -> contacts.list(scanner);
                case "search" -> contacts.search(scanner);
            }
            if (!exit) System.out.println();
        }
        scanner.close();
    }
}