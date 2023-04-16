package user;

/* Base class for now, will be more robust in the future */

//  imports
import team.Team;

public class User implements java.io.Serializable {
    
    /* fields and constants */
    private static final long serialVersionUID = 202304161740L;

    private final String USERNAME;
    private Team team;

    /* constructor */
    public User(String username) {
        this.USERNAME = username;
        this.team = null;
    }

    /* getters */
    public String getUsername() {
        return this.USERNAME;
    }

    /* setters */
    public void setTeam(Team team) {
        this.team = team;
    }

    /* equals */
    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof User otherUser)
            return this.USERNAME.equals(otherUser.USERNAME) && this.team.equals(otherUser.team);
        return false;
    }

    /* toString */
    public String toString() {
        if (team == null)
            return String.format("%s", this.USERNAME);
        return String.format("Username: %s%nTeam: %s", this.USERNAME, this.team.getFullName());
    }
}
