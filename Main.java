import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        User user = new User("admin", "Password123!");

        System.out.println("=== SecureBuddy Login ===");

        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();

        if (!user.authenticate(enteredPassword)) {
            System.out.println("Login failed.");
            return;
        }

        PasswordManager manager = new PasswordManager(user);

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n=== SecureBuddy ===");
            System.out.println("1. Add Entry");
            System.out.println("2. View Entries");
            System.out.println("3. Search Entry");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("ID: ");
                int id = input.nextInt();
                input.nextLine();

                System.out.print("Account Name: ");
                String account = input.nextLine();

                System.out.print("Username: ");
                String username = input.nextLine();

               System.out.print("Password: ");
               
                String password = input.nextLine();

                PasswordValidator validator = new PasswordValidator();

                int score = validator.getStrengthScore(password);

                System.out.println("Strength Score: " + score + "/3");

                if (score == 3) {
                    System.out.println("Password Strength: Strong");
                }
                else if (score == 2) {
                    System.out.println("Password Strength: Moderate");
                }
                else {
                    System.out.println("Password Strength: Weak");
                }

                PasswordEntry entry =
                    new PasswordEntry(id, account, username, password);

                manager.addEntry(entry);

                System.out.println("Entry added.");
            }

            else if (choice == 2) {

                for (PasswordEntry entry : manager.getAllEntries()) {
                    System.out.println(entry);
                }
            }

            else if (choice == 3) {

                System.out.print("Enter account name: ");
                String search = input.nextLine();

                PasswordEntry result =
                        manager.searchEntry(search);

                if (result != null) {
                    System.out.println(result);
                }
                else {
                    System.out.println("Entry not found.");
                }
            }
        }

        System.out.println("Goodbye!");
        input.close();
    }
}