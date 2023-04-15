package login;

//  imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import login.UsernameException.UsernameError;

public final class UsernameUtils {

    /* do not let anyone instantiate this class */
    private UsernameUtils() {}

    /* fields and constants */
    private static final int MINIMUM_USERNAME_LENGTH = 3;
    private static final int MAXIMUM_USERNAME_LENGTH = 20;

    private static final String ILLEGAL_CHARACTERS = "!@#$%^&*()-_=+[{]}|;:',<.>/?`~ ";

    /* method to validate a username */
    public static boolean isValidUsername(final String username) throws UsernameException {
        if (username == null || username.equals("")) throw new UsernameException(UsernameError.NULL_OR_EMPTY);
        if (username.length() < MINIMUM_USERNAME_LENGTH) throw new UsernameException(UsernameError.LENGTH_TOO_SHORT);
        if (username.length() > MAXIMUM_USERNAME_LENGTH) throw new UsernameException(UsernameError.LENGTH_TOO_LONG);
        if (username.chars().anyMatch(c -> ILLEGAL_CHARACTERS.contains(Character.toString((char) c)))) throw new UsernameException(UsernameError.ILLEGAL_CHARACTER);
        if (exists(username)) throw new UsernameException(UsernameError.ALREADY_EXISTS);

        return true;
    }

    /* method to check if a username already exists */
    private static boolean exists(final String username) {

        try (Scanner input = new Scanner(new File("data/users/usernames.dat"))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.equals(username)) return true;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("usernames.dat file not found, ensure it is located in data/users");
        }

        return false;
    }
}
