import view.*;
import users.UserRegisterInputBoundary;
import users.UserRegisterPresenter;
import users.UserRegisterDsGateway;
import users.UserRegisterInteractor;
import entities.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities engine
        UserRegisterDsGateway user;
        try {
            user = new FileUser("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        UserRegisterPresenter userRegisterPresenter = new UserRegisterResponseFormatter();
        UserFactory userFactory = new CommonUserFactory();
        UserRegisterInputBoundary userRegisterInteractor = new UserRegisterInteractor(
                user, userRegisterPresenter, userFactory);
        UserRegisterController userRegisterController = new UserRegisterController(
                userRegisterInteractor
        );

        // Build the GUI, plugging in the parts
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        screens.add(welcomeScreen, "welcome");

        RegisterScreen registerScreen = new RegisterScreen(userRegisterController);
        screens.add(registerScreen, "register");

        LoginScreen loginScreen = new LoginScreen();
        screens.add(loginScreen, "login");

        LoggedInScreen loggedInScreen = new LoggedInScreen();
        screens.add(loggedInScreen, "loggedIn");

        cardLayout.show(screens, "welcome");
//        cardLayout.show(screens, "register");
//        cardLayout.show(screens, "login");
//        cardLayout.show(screens, "loggedIn");

        application.pack();
        application.setVisible(true);


    }

}