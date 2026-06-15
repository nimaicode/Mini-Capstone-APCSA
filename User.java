public class User {

    private String username;
    private String password;
    private boolean loggedIn;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        loggedIn = false;
    }

    public String getUserName() {
        return username;
    }

    public boolean authenticate(String enteredPassword) {
        if (password.equals(enteredPassword)) {
            loggedIn = true;
            return true;
        }

        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}