package main;

//  imports
import login.LoginControl;
import user.User;

public class Main {
    
    public static void main(String[] args) {
        User user = LoginControl.runCLI();
        System.out.printf("%s", user);
    }
}
