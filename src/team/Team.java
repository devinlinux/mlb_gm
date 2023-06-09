package team;

public class Team implements java.io.Serializable {

    /* fields and constants */
    @java.io.Serial
    private static final long serialVersionUID = 202304161739L;

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

    /* equals */
    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof Team otherTeam)
            return this.TEAM == otherTeam.TEAM;
        return false;
    }

    /* toString */
    @Override
    public String toString() {
        return this.getFullName();
    }
}
