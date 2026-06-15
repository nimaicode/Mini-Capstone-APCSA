import java.util.ArrayList;

public class PasswordManager {

    private ArrayList<PasswordEntry> entries;
    private User currentUser;

    public PasswordManager(User currentUser) {

        this.currentUser = currentUser;
        entries = new ArrayList<PasswordEntry>();
    }

    public void addEntry(PasswordEntry entry) {
        entries.add(entry);
    }

    public void deleteEntry(int id) {

        for (int i = 0; i < entries.size(); i++) {

            if (entries.get(i).getId() == id) {

                entries.remove(i);
                break;
            }
        }
    }

    public ArrayList<PasswordEntry> getAllEntries() {
        return entries;
    }

    public PasswordEntry searchEntry(String name) {

        for (PasswordEntry entry : entries) {

            if (entry.getAccountName().equalsIgnoreCase(name)) {
                return entry;
            }
        }

        return null;
    }
}