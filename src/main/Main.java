package main;

//  imports
import login.LoginControl;
import user.User;
import team.Team;
import cli.TeamCreation;
import util.Util;

import java.io.Console;

public class Main {
    
    public static void main(String[] args) {
        Util.clearConsole();

        Console console = System.console();

        User user = LoginControl.runCLI(console);
        Team team = TeamCreation.runCLI(console);

        user.setTeam(team);

        System.out.printf("%s%n%s%n", user, team);
        Util.writeUserInformation(user);
    }
}
