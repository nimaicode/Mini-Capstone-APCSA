import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public void saveEntries(ArrayList<PasswordEntry> entries) {

        try {

            PrintWriter writer = new PrintWriter(filePath);

            for (PasswordEntry entry : entries) {

                writer.println(
                        entry.getId() + ","
                                + entry.getAccountName() + ","
                                + entry.getUsername() + ","
                                + entry.getPassword()
                );
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving entries.");
        }
    }

    public ArrayList<PasswordEntry> loadEntries() {

        ArrayList<PasswordEntry> entries =
                new ArrayList<PasswordEntry>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(filePath));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 4) {

                    int id = Integer.parseInt(parts[0]);

                    entries.add(
                            new PasswordEntry(
                                    id,
                                    parts[1],
                                    parts[2],
                                    parts[3]
                            )
                    );
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error loading entries.");
        }

        return entries;
    }

    public boolean fileExists() {

        File file = new File(filePath);

        return file.exists();
    }

    public void deleteEntry(int id) {

        ArrayList<PasswordEntry> entries = loadEntries();

        for (int i = 0; i < entries.size(); i++) {

            if (entries.get(i).getId() == id) {

                entries.remove(i);
                break;
            }
        }

        saveEntries(entries);
    }

    public String maskPassword(String password) {

        String masked = "";

        for (int i = 0; i < password.length(); i++) {
            masked += "*";
        }

        return masked;
    }
}