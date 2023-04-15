package login;

//  imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class LoginSystem {

    /* do not let anyone instantiate this class */
    private LoginSystem() {}

    /* method to create account */
    private static final String USERNAME_FILE_PATH = "data/users/usernames.dat";
    private static final String PASSWORD_FILE_PATH = "data/users/passwords.dat";
    private static final String SALT = "×£õ¯ýQÐÑNòí²¸F8ô_ÇB{¨ÙÖ)®+F*E´T¤Y¬XÚa.fL]ÿH®ÊAPÊ½UþÍm]ÐÆÐß`-ÚRck%âÅÔÞdÙ_Í§½ËcrªtÕU{»ä8×ÌBoÛíñíÏ¸bí¿%Ö['T2ÈqÌþªtqæx!¯ßp(¯ìÒÀ¢Å*÷+";

    //  method to verify a username and password combination
    public static boolean verifyLogin(final String username, final String password) {
        String hashedPassword;
        try {
            hashedPassword = EncryptionUtil.hashWithSalt(password, SALT);
        } catch (NoSuchAlgorithmException e) {
            System.err.printf("Error hashing password: %s%n", e.getMessage());
            return false;
        }

        try (BufferedReader userReader = new BufferedReader(new FileReader(USERNAME_FILE_PATH));
             BufferedReader passReader = new BufferedReader(new FileReader(PASSWORD_FILE_PATH))) {
            String userLine, passLine;
            while ((userLine = userReader.readLine()) != null && (passLine = passReader.readLine()) != null)
                if (userLine.trim().equals(username) && passLine.trim().equals(hashedPassword))
                    return true;            
        } catch (IOException e) {
            System.err.printf("Error reading username or password file: %s%n", e.getMessage());
            return false;
        }
        return false;
    }

    //  method to create a new user
    public static boolean createUser(final String username, final String password) {
        String hashedPassword;
        try {
            hashedPassword = EncryptionUtil.hashWithSalt(password, SALT);
        } catch (NoSuchAlgorithmException e) {
            System.err.printf("Error hashing password: %s%n", e.getMessage());
            return false;
        }

        try {
            UsernameUtils.isValidUsername(username);
        } catch (UsernameException e) {
            System.err.printf("Error with username: %s%n", e.getMessage());
            return false;
        }

        try {
            PasswordUtils.isValidPassword(password);
        } catch (PasswordException e) {
            System.err.printf("Error with password: %s%n", e.getMessage());
            return false;
        }

        try (BufferedWriter userWriter = new BufferedWriter(new FileWriter(USERNAME_FILE_PATH, true));
             BufferedWriter passWriter = new BufferedWriter(new FileWriter(PASSWORD_FILE_PATH, true))) {
            userWriter.write(username + "\n");
            passWriter.writer(hashedPassword + "\n");
        } catch (IOException e) {
            System.err.printf("Error writing to user or password file: %s%n", e.getMessage())''
        }
    }

    private static final class EncryptionUtil {


        /* Do not let anyone instantiate this class */
        private EncryptionUtil() {}

        private static String hashWithSalt(final String password, final String salt) throws NoSuchAlgorithmException {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] saltedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

            md.reset();
            byte[] digest = md.digest(saltedBytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) 
                sb.append(String.format("%02x", b & 0xff));
            return sb.toString();
        }        
    }
}
