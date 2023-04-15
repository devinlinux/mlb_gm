package login;

public class UsernameException extends Exception {

    public enum UsernameError {
        ALREADY_EXISTS("Username already exists"),
        NULL_OR_EMPTY("Username cannot be null or empty"),
        ILLEGAL_CHARACTER("Username cannot contain an illegal character"),
        LENGTH_TOO_SHORT("Username length must be greater than or equal to 3 characters"),
        LENGTH_TOO_LONG("Username length must be less than 21 characters");

        private final String MESSAGE;

        UsernameError(final String MESSAGE) {
            this.MESSAGE = MESSAGE;
        }

        public String getMessage() {
            return this.MESSAGE;
        }
    }

    public UsernameException(UsernameError error) {
        super(error.getMessage());
    }
}
