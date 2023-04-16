package login;

//  imports
import java.util.Random;

import login.PasswordException.PasswordError;

public final class PasswordUtils {

    /* do not let anyone instantiate this class */
    private PasswordUtils() {}

    /* fields and constants */
    private static final int MINIMUM_PASSWORD_LENGTH = 16;
    private static final int MAXIMUM_PASSWORD_LENGTH = 10000;

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyk";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[{]}|;:',<.>/?`~";

    /* method to generate a secure password of 16 characters with at least 1 uppercase letter, 1 lowercase letter, and 1 symbol */
    public static String genPassword() {
        String charPool = UPPERCASE_LETTERS + LOWERCASE_LETTERS + SYMBOLS;
        Random rand = new Random();

        StringBuilder password = new StringBuilder();

        //  fill the password with a random combination of characters from the charPool
        for (int i = 0; i < MINIMUM_PASSWORD_LENGTH; i++) 
            password.append(charPool.charAt(rand.nextInt(charPool.length())));
        
        //  ensure that the password has at least one uppercase letter, lowercase letter, and symbol
        int uppercaseIndex = rand.nextInt(MINIMUM_PASSWORD_LENGTH), lowercaseIndex = 0, symbolIndex = 0;
        while (lowercaseIndex != uppercaseIndex)
            lowercaseIndex = rand.nextInt(MINIMUM_PASSWORD_LENGTH);
        while (symbolIndex != uppercaseIndex && symbolIndex != lowercaseIndex)
            symbolIndex = rand.nextInt(MINIMUM_PASSWORD_LENGTH);

        password.setCharAt(uppercaseIndex, UPPERCASE_LETTERS.charAt(rand.nextInt(UPPERCASE_LETTERS.length())));
        password.setCharAt(lowercaseIndex, LOWERCASE_LETTERS.charAt(rand.nextInt(LOWERCASE_LETTERS.length())));
        password.setCharAt(symbolIndex, SYMBOLS.charAt(rand.nextInt(SYMBOLS.length())));

        return password.toString();
    }

    /* method to validate a password */
    public static boolean isValidPassword(final String password) throws PasswordException {
        if (password == null || password.equals("")) throw new PasswordException(PasswordError.NULL_OR_EMPTY);
        if (password.length() < MINIMUM_PASSWORD_LENGTH) throw new PasswordException(PasswordError.LENGTH_TOO_SHORT);
        if (password.length() > MAXIMUM_PASSWORD_LENGTH) throw new PasswordException(PasswordError.LENGTH_TOO_LONG);
        if (password.contains(" ")) throw new PasswordException(PasswordError.ILLEGAL_WHITESPACE);

        boolean hasUppercase = password.chars().anyMatch(c -> UPPERCASE_LETTERS.contains(Character.toString((char) c)));
        boolean hasLowercase = password.chars().anyMatch(c -> LOWERCASE_LETTERS.contains(Character.toString((char) c)));
        boolean hasSymbol = password.chars().anyMatch(c -> SYMBOLS.contains(Character.toString((char) c)));

        if (!hasUppercase) throw new PasswordException(PasswordError.MISSING_UPPERCASE_LETTER);
        if (!hasLowercase) throw new PasswordException(PasswordError.MISSING_LOWERCASE_LETTER);
        if (!hasSymbol) throw new PasswordException(PasswordError.MISSING_SYMBOL); 
        
        return hasUppercase && hasLowercase && hasSymbol;
    }
}