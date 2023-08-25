import data_access.FileUserDataAccessObject;
import interface_adapters.UserSignupController;
import interface_adapters.UserViewModel;
import users.*;
import view.*;
import users.UserSignupInputBoundary;
import users.UserSignupInteractor;
import entities.*;
import view.LayoutManager;
import interface_adapters.UserSignupPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        UserViewModel userViewModel = new UserViewModel();
        JPanel views = new JPanel(cardLayout);
        LayoutManager viewManager = new LayoutManager(views, cardLayout, userViewModel);
        application.add(views);

        // Create the parts to plug into the Use Case+Entities engine
        UserSignupDataAccessInterface user;
        try {
            user = new FileUserDataAccessObject("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        UserSignupOutputBoundary userSignupOutputBoundary = new UserSignupPresenter();
        UserFactory userFactory = new CommonUserFactory();
        UserSignupInputBoundary userRegisterInteractor = new UserSignupInteractor(
                user, userSignupOutputBoundary, userFactory);
        UserSignupController userSignupController = new UserSignupController(
                userRegisterInteractor
        );

        // Build the GUI, plugging in the parts
        WelcomeView welcomeView = new WelcomeView(userViewModel);
        views.add(welcomeView, "welcome");

        SignupView signupView = new SignupView(userSignupController, userViewModel);
        views.add(signupView, "signup");

        LoginView loginView = new LoginView(userViewModel);
        views.add(loginView, "login");

        LoggedInView loggedInView = new LoggedInView();
        views.add(loggedInView, "loggedIn");

        cardLayout.show(views, "welcome");
//        cardLayout.show(views, "register");
//        cardLayout.show(views, "login");
//        cardLayout.show(views, "loggedIn");

        application.pack();
        application.setVisible(true);


    }

}