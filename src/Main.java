import screens.*;
import user_register_use_case.UserInputBoundary;
import user_register_use_case.UserPresenter;
import user_register_use_case.UserRegisterDsGateway;
import user_register_use_case.UserRegisterInteractor;
import users.*;

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
        UserPresenter presenter = new UserResponseFormatter();
        UserFactory userFactory = new CommonUserFactory();
        UserInputBoundary interactor = new UserRegisterInteractor(
                user, presenter, userFactory);
        UserRegisterController userRegisterController = new UserRegisterController(
                interactor
        );

        // Build the GUI, plugging in the parts
        RegisterScreen registerScreen = new RegisterScreen(userRegisterController);
        screens.add(registerScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);

        // Unused screens; we'll uncomment this later
//        WelcomeScreen welcomeScreen = new WelcomeScreen();
//        LoginScreen loginScreen = new LoginScreen();
//        LoggedInScreen loggedInScreen = new LoggedInScreen();
//        screens.add(welcomeScreen, "register");
//        screens.add(loginScreen, "login");
//        screens.add(loggedInScreen, "loggedIn");

    }

}