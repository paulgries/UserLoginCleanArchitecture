import screens.*;
import users.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        UserRegisterDsGateway user;
        try {
            user = new FileUser("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        UserPresenter presenter = new UserResponseFormatter();
        UserFactory userFactory = new CommonUserFactory();
        UserInputBoundary interactor = new UserRegisterInteractor(
                user, presenter, userFactory);
        UserRegisterController userRegisterController = new UserRegisterController(
                interactor
        );


        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        WelcomeScreen welcomeScreen = new WelcomeScreen();
        RegisterScreen registerScreen = new RegisterScreen(userRegisterController);
        LoginScreen loginScreen = new LoginScreen();
        LoggedInScreen loggedInScreen = new LoggedInScreen();
//        screens.add(welcomeScreen, "register");
        screens.add(registerScreen, "welcome");
//        screens.add(loginScreen, "login");
//        screens.add(loggedInScreen, "loggedIn");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);
    }

}