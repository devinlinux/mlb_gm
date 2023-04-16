package cli;

//  imports
import java.io.Console;

import team.Team;
import util.Util;
import team.MLBTeam;

public final class TeamCreation {
    
    /* do not let anyone instantiate this class */
    private TeamCreation() {}

    //  method to run the cli
    public static Team runCLI(Console console) {
        
        if (console == null) {
            System.err.printf("Console not available");
            System.exit(1);
        }

        Team team = getTeamFromOptions(console);

        return team;
    }

    private static Team getTeamFromOptions(Console console) {

        boolean satisfied = false;
        Team choiceTeam = null;

        do {
            console.printf("Please select your team from the options below:%n");

            MLBTeam[] teamChoices = MLBTeam.values();
            int teamIteration = 1;
            for (MLBTeam team : teamChoices) {
                console.printf("%d. %s%n", teamIteration, Util.formatEnumTeamName(team));
                teamIteration++;
            }

            int choice = -1;
            try {
                choice = Integer.parseInt(console.readLine("What team do you want: "));
            } catch (NumberFormatException e) {
                console.printf("That is not a valid choice, please enter a number%n");
            }
            
            if (choice > 0 && choice < 31) {
                choiceTeam = new Team(teamChoices[choice - 1]);
                satisfied = true;
            }
            else 
                console.printf("That is not a valid choice, please try again");
        } while (!satisfied);

        return choiceTeam;
    }
}
