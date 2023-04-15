package login;

public class PasswordException extends Exception {
    
    public enum PasswordError {
        NULL_OR_EMPTY("Password cannot be null or empty"),
        LENGTH_TOO_SHORT("Password length must be greater than or equal to 16 characters"),
        LENGTH_TOO_LONG("Password length must be less than 10001 characters"),
        MISSING_UPPERCASE_LETTER("Password must contain at least 1 uppercase letter"),
        MISSING_LOWERCASE_LETTER("Password must contain at least 1 lowercase letter"),
        MISSING_SYMBOL("Password must contain at least 1 symbol");

        private final String MESSAGE;

        PasswordError(final String MESSAGE) {
            this.MESSAGE = MESSAGE;
        }

        public String getMessage() {
            return this.MESSAGE;    
        }
    }

    public PasswordException(PasswordError error) {
        super(error.getMessage());
    }
}
