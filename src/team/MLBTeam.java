package team;

public enum MLBTeam {
    CHICAGO_WHITE_SOX("Chicago", "White Sox"),
    CLEVELAND_GUARDIANS("Cleveland", "Guardians"),
    DETROIT_TIGERS("Detroit", "Tigers"),
    KANSAS_CITY_ROYALS("Kansas City", "Royals"),
    MINNESOTA_TWINS("Minnesota", "Twins"),
    CHICAGO_CUBS("Chicago", "Cubs"),
    CINCINNATI_REDS("Cincinnati", "Reds"),
    MILWAUKEE_BREWERS("Milwaukee", "Brewers"),
    PITTSBURGH_PIRATES("Pittsburgh", "Pirates"),
    SAINT_LOUIS_CARDINALS("Saint Louis", "Cardinals"),
    BALTIMORE_ORIOLES("Baltimore", "Orioles"),
    BOSTON_RED_SOX("Boston", "Red Sox"),
    NEW_YORK_YANKEES("New York", "Yankees"),
    TAMPA_BAY_RAYS("Tampa Bay", "Rays"),
    TORONTO_BLUE_JAYS("Toronto", "Blue Jays"),
    ATLANTA_BRAVES("Atlanta", "Braves"),
    MIAMI_MARLINS("Miami", "Marlins"),
    NEW_YORK_METS("New York", "Mets"),
    PHILADELPHIA_PHILLIES("Philadelphia", "Phillies"),
    WASHINGTON_NATIONALS("Washington", "Nationals"),
    HOUSTON_ASTROS("Houston", "Astros"),
    LOS_ANGELES_ANGELS("Los Angeles", "Angels"),
    OAKLAND_ATHLETICS("Oakland", "Athletics"),
    SEATTLE_MARINERS("Seattle", "Mariners"),
    TEXAS_RANGERS("Texas", "Rangers"),
    ARIZONA_DIAMONDBACKS("Arizona", "Diamondbacks"),
    COLORADO_ROCKIES("Colorado", "Rockies"),
    LOS_ANGELES_DODGERS("Los Angeles", "Dodgers"),
    SAN_DIEGO_PADRES("San Diego", "Padres"),
    SAN_FRANCISCO_GIANTS("San Francisco", "Giants");

    private final String LOCATION, NAME;

    MLBTeam(final String LOCATION, final String NAME) {
        this.LOCATION = LOCATION;
        this.NAME = NAME;
    }

    public String getLocation() {
        return this.LOCATION;
    }

    public String getName() {
        return this.NAME;
    }

    public String getFullName() {
        return String.format("%s %s", this.LOCATION, this.NAME);
    }
}
