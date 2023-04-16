package main;

//  imports
import login.LoginControl;
import user.User;
import util.Util;

public class Main {
    
    public static void main(String[] args) {
        User user = LoginControl.runCLI();
        System.out.printf("%s%n", user);
    }
}
