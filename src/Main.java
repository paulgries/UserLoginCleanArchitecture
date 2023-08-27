import data_access.FileUserDataAccessObject;
import data_access.UserSignupDataAccessInterface;
import interface_adapters.UserSignupController;
import interface_adapters.UserViewModel;
import users.*;
import view.*;
import users.UserSignupInputBoundary;
import users.UserSignupInteractor;
import entities.*;
import view.ViewManager;
import interface_adapters.UserSignupPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.
        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // The data for the views, such as username and password. This
        // will be changed by a presenter object that is reporting the
        // results from the use case. This is an observable, and will
        // be observed by the layout manager.
        UserViewModel userViewModel = new UserViewModel();

        /*
         The observer watching for changes in the userViewModel. It will
         react to changes in application state by changing which view
         is showing. This is an anonymous object because we don't need to
         refer to it later.
        */
        new ViewManager(views, cardLayout, userViewModel);

        // The object that knows how to start a use case.
        UserSignupController userSignupController = createUserSignupUseCase();

        // Build the GUI, plugging in the screens.
        createViewsAndAddToPanel(userViewModel, views, userSignupController);

        // Show the first view.
        cardLayout.show(views, "welcome");
//        cardLayout.show(views, "register");
//        cardLayout.show(views, "login");
//        cardLayout.show(views, "loggedIn");

        application.pack();
        application.setVisible(true);
    }

    private static void createViewsAndAddToPanel(UserViewModel userViewModel, JPanel views, UserSignupController userSignupController) {
        WelcomeView welcomeView = new WelcomeView(userViewModel);
        views.add(welcomeView, "welcome");

        SignupView signupView = new SignupView(userSignupController, userViewModel);
        views.add(signupView, "signup");

        LoginView loginView = new LoginView(userViewModel);
        views.add(loginView, "login");

        LoggedInView loggedInView = new LoggedInView();
        views.add(loggedInView, "loggedIn");
    }

    private static UserSignupController createUserSignupUseCase() {
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
        return userSignupController;
    }

}