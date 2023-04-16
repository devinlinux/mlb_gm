package util;

//  imports
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.File;

import user.User;

public final class Util {
    
    /* do not let anyone instantiate this class */
    private Util() {}

    /* fields and constants */
    private static final String SEP = File.separator;
    private static final String USER_SERIALIZATION_FOLDER_PATH = String.format("data%suser_information%s", SEP, SEP);
    private static final String USER_SERIALIZATION_SUFFIX = "_data.ser";

    /* methods */

    //  method to write User information to a serialization file
    public static void writeUserInformation(final User user) {
        try {
            FileOutputStream fileOut = new FileOutputStream(USER_SERIALIZATION_FOLDER_PATH + SEP + user.getUsername() + USER_SERIALIZATION_SUFFIX);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(user);

            fileOut.close();
            objectOut.close();
        } catch (IOException e) {
            System.err.printf("Error writing user information for %s: %s%n", user.getUsername(), e.getMessage());
            System.exit(1);
        }
    }

    //  method to read in User information from a serialization file and return the User
    public static User readUserInformation(final String username) {
        try {
            FileInputStream fileIn = new FileInputStream(USER_SERIALIZATION_FOLDER_PATH + SEP + username + USER_SERIALIZATION_SUFFIX);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            User user = (User) objectIn.readObject();

            fileIn.close();
            objectIn.close();

            return user;
        } catch (IOException | ClassNotFoundException e) {
            System.err.printf("Error reading user information for %s: %s%n", username, e.getMessage());
            System.exit(1);
            return null;
        }
    }

    //  method to format enum names
    public static String formatEnumTeamName(Enum<?> value) {
        String name = value.name();

        name = name.toLowerCase().replace('_', ' ');
        String[] words = name.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)));
            sb.append(word.substring(1));
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    //  method to sleep and pause the program
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.printf("Error sleeping the program: %s%n", e.getMessage());
        }
    }

    //  method to prepare the console
    public static void prepareConsole() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            if (os.contains("windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else 
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.printf("Error preparing console: %s%n", e.getMessage());
        }
    }
}
