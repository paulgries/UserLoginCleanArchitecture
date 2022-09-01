import screens.LoginScreen;
import screens.WelcomeScreen;
import screens.SignupScreen;
import screens.LoggedInScreen;

public class Main {
    public static void main(String[] args) {

        WelcomeScreen welcomeScreen = new WelcomeScreen("Login Example");
        SignupScreen signupScreen = new SignupScreen("Login Example");
        LoginScreen loginScreen = new LoginScreen("Login Example");
        LoggedInScreen loggedInScreen = new LoggedInScreen("Login Example");
        welcomeScreen.setVisible(true);
//        signupScreen.setVisible(true);
//        loginScreen.setVisible(true);
//        loggedInScreen.setVisible(true);
    }
}