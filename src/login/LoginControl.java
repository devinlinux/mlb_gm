package login;

//  imports
import java.io.Console;

import user.User;

public final class LoginControl {

    /* do not let anyone instantiate this class */
    private LoginControl() {}

    /* fields and constants */
    private static final int MAX_LOGIN_ATTEMPTS = 4;

    //  method to handle the login/creation of an account
    public static User run() {
        Console console = System.console();

        if (console == null) {
            System.err.printf("Console not available");
            System.exit(1);
        }

        User user = getAction(console);

        return user;
    }

    //  method to see what the user wants to do
    private static User getAction(Console console) {
        console.printf("What would you like to do:%n");
        console.printf("1. Create a new account%n2. Log in to an existing account%n3. Exit the program%n%n");

        String input = console.readLine("Enter your choice: ");

        switch (input) {
            case "1" -> {
                return createUser(console);
            }
            case "2" -> {
                return login(console);
            }
            case "3" -> {
                System.exit(0);
                break;
            }
            default -> {
                getAction(console);
                break;
            }
        }

        return null;
    }

    public static User createUser(Console console) {
        int attempts = 0;
        boolean validCombo = false;
        User user = null;

        do {

            //  getting username
            String username = console.readLine("Enter the username for your account: ");
            console.printf("Your password must be at least 16 characters and contain at least 1 uppercase letter, 1 lowercase letter, and 1 symbol%n");
            console.printf("You can either:%n1. Make your own password%n2. Have a password generated for you%n%n");

            boolean satisfied = false;
            String password = null;

            //  getting password
            do {
                String passwordMethod = console.readLine("Enter your choice: ");

                switch (passwordMethod) {
                    case "1" -> {
                        password = new String(console.readPassword("Enter your password: "));
                        satisfied = true;
                        break;
                    }

                    case "2" -> {
                        password = PasswordUtils.genPassword();
                        console.printf("Your password is: %s%n", password);
                        satisfied = true;
                        break;
                    }
                    default -> {
                        console.printf("Sorry, that is not a valid option, please try again%n");
                        break;
                    }
                }
            } while (!satisfied);
        
            validCombo = LoginSystem.createUser(username, password);
            attempts++;

            if (validCombo)
                user = new User(username);
        } while (validCombo == false && attempts < MAX_LOGIN_ATTEMPTS);

        if (attempts == MAX_LOGIN_ATTEMPTS) {
            console.printf("You have failed authentification too many times, exiting...%n");
            System.exit(1);
        }

        console.printf("Successfully created your account, welcome%n");
        return user;
    }

    public static User login(Console console) {
        int attempts = 0;
        boolean validCombo = false;
        User user = null;
        
        console.printf("Welcome back, please enter your username and password%n");

        do {
            String username = console.readLine("What is your username: ");
            String password = new String(console.readPassword("What is your password: "));

            validCombo = LoginSystem.verifyLogin(username, password);
            if (!validCombo)
                console.printf("username or password is incorrect%n");
            else 
                user = new User(username);
            attempts++;
        } while (validCombo == false && attempts < MAX_LOGIN_ATTEMPTS);

        if (attempts == MAX_LOGIN_ATTEMPTS) {
            console.printf("You have failed authentification too many times, exiting...%n");
            System.exit(1);
        }

        console.printf("Successfully logged in, welcome%n");
        return user;
    }

    public static void main(String[] args) {
        run();
    }
}