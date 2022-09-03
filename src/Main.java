import screens.*;
import users.*;

public class Main {
    public static void main(String[] args) {

        InMemoryUser user = new InMemoryUser();
        UserPresenter presenter = new UserResponseFormatter();
        UserFactory userFactory = new CommonUserFactory();
        UserInputBoundary interactor = new UserRegisterInteractor(
                user, presenter, userFactory);
        UserRegisterController userRegisterController = new UserRegisterController(
                interactor
        );

        WelcomeScreen welcomeScreen = new WelcomeScreen("Login Example");
        RegisterScreen registerScreen = new RegisterScreen("Login Example", userRegisterController);
        LoginScreen loginScreen = new LoginScreen("Login Example");
        LoggedInScreen loggedInScreen = new LoggedInScreen("Login Example");
//        welcomeScreen.setVisible(true);
        registerScreen.setVisible(true);
//        loginScreen.setVisible(true);
//        loggedInScreen.setVisible(true);
    }
}