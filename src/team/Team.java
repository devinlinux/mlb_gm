package team;

public class Team {

    /* fields and constants */
    private final MLBTeam TEAM;

    //  constructor
    public Team(MLBTeam team) {
        this.TEAM = team;
    }

    /* getters */
    public String getLocation() {
        return TEAM.getLocation();
    }

    public String getName() {
        return TEAM.getName();
    }

    public String getFullName() {
        return TEAM.getFullName();
    }
}
