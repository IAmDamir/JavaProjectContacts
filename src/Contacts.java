import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Contacts implements Serializable {
    ArrayList<Contact> contacts = new ArrayList<>();
    String filename = "test_file";

    public Contacts() {}

    private void writeObject () {
        if (filename != null) {
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(contacts);
                fos.close();
                oos.close();
                System.out.println("Written");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readObject () {
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contacts = (ArrayList<Contact>) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void add(Scanner scanner) {
        System.out.print("Enter the type (person, organization):");
        String type = scanner.nextLine().trim();
        if ("organization".equals(type)) {
            Organization organization = new Organization();
            organization.add(scanner);
            contacts.add(organization);
            System.out.println("The record added.");
        } else if ("person".equals(type)) {
            Person person = new Person();
            person.add(scanner);
            contacts.add(person);
            System.out.println("The record added.");
        }
        writeObject();
    }

    public void count() {
        readObject();
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    public void list(Scanner scanner) {
        readObject();
        Pattern numberPattern = Pattern.compile("[1-9][0-9]*");
        if (contacts.size() == 0) {
            System.out.println("No records to list!");
        } else {
            String currentAction = "[list]";
            for (int i = 0; i < contacts.size(); i++) {
                System.out.printf("%d. %s %n", i+1, contacts.get(i).getName());
            }
            System.out.printf("%n%s Enter action ([number], back):", currentAction);
            String action = scanner.nextLine().trim();
            Matcher numberMatcher = numberPattern.matcher(action);
            if (numberMatcher.matches()) {
                record(scanner, action);
            }
        }
    }

    public void remove(int userSelect) {
        contacts.remove(userSelect - 1);
        System.out.println("The record removed!");
    }

    public void edit(Scanner scanner, int userSelect) {
        contacts.get(userSelect- 1).edit(scanner);
    }

    public void search(Scanner scanner) {
        readObject();

        ArrayList<Contact> searchList = new ArrayList<>();
        String currentAction = "[search]";
        boolean search = true;
        while (search) {
            System.out.print("Enter search query:");
            String searchedContact = scanner.nextLine().trim();

            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).containsQuery(searchedContact)) {
                    searchList.add(contacts.get(i));
                    System.out.printf("%d. %s", i + 1, contacts.get(i).getName());
                }
            }

            System.out.printf("%n%s Enter action ([number], back, again):", currentAction);
            String action = scanner.nextLine().trim();

            switch (action) {
                case "back":
                    search = false;
                    break;
                case "again":
                    System.out.println();
                    break;
                default:
                    boolean menu = false;
                    currentAction = "[record]";
                    int userSelect = Integer.parseInt(action);
                    searchList.get(Integer.parseInt(action) - 1).info();
                    while (!menu) {
                        System.out.printf("%n%s Enter action (edit, delete, menu):", currentAction);
                        action = scanner.nextLine().trim();
                        switch (action) {
                            case "edit" -> edit(scanner, userSelect);
                            case "delete" -> remove(userSelect);
                            case "menu" -> {
                                menu = true;
                                search = false;
                            }
                        }
                        writeObject();
                    }
                    break;
            }
        }
    }

    public void record(Scanner scanner, String action) {
        boolean menu = false;
        String currentAction = "[record]";
        int userSelect = Integer.parseInt(action);
        contacts.get(Integer.parseInt(action) - 1).info();
        while (!menu) {
            System.out.printf("%n%s Enter action (edit, delete, menu):", currentAction);
            action = scanner.nextLine().trim();
            switch (action) {
                case "edit" -> edit(scanner, userSelect);
                case "delete" -> remove(userSelect);
                case "menu" -> menu = true;
            }
            writeObject();
        }
    }
}