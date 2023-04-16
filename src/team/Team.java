package team;

public class Team implements java.io.Serializable {

    /* fields and constants */
    private final MLBTeam TEAM;
    private int wins, losses;

    //  constructor
    public Team(MLBTeam team) {
        this.TEAM = team;
        this.wins = 0;
        this.losses = 0;
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

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public String getRecord() {
        return String.format("%d-%d", this.wins, this.losses);
    }
}
