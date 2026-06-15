public class PasswordEntry {

    private int id;
    private String accountName;
    private String username;
    private String password;

    public PasswordEntry(int id, String accountName,
                         String username, String password) {
        this.id = id;
        this.accountName = accountName;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String user) {
        username = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return accountName + " | " + username;
    }
}