import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Contacts implements Serializable {
    ArrayList<Contact> contactsList = new ArrayList<>();
    String filename = "contacts";
    static Contacts contactsStatic;

    public static Contacts get(){
        if (contactsStatic == null)
            contactsStatic = new Contacts();
        return contactsStatic;
    }

    private Contacts() {
        readObject();
    }

    public List<Contact> getList(){
        return Collections.unmodifiableList(contactsList);
    }

    public void addContact(Contact contact){
        contactsList.add(contact);
        writeObject();
    }

    public void editContact(Contact contact, int index){
        contactsList.set(index, contact);
        writeObject();
    }

    public void removeContact(int index){
        contactsList.remove(index);
        writeObject();
    }

    private void writeObject () {
        if (filename != null) {
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(contactsList);
                fos.close();
                oos.close();
                System.out.println("Written");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readObject () {
        try {
            File file = new File(filename);
            if (!file.exists())
                file.createNewFile();
//            new File(filename).createNewFile();
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contactsList = (ArrayList<Contact>) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}