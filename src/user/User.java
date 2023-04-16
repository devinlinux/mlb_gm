package user;

/* Base class for now, will be more robust in the future */

public class User {
    
    /* fields and constants */
    private final String USERNAME;

    public User(String username) {
        this.USERNAME = username;
    }

    /* getters */
    public String getUsername() {
        return this.USERNAME;
    }
}
