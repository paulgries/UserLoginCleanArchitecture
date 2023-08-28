package view;

import interface_adapters.UserViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewManager implements PropertyChangeListener {
    public static final String WELCOME = "welcome";
    public static final String SIGN_UP = "sign up";
    public static final String LOG_IN = "log in";
    public static final String LOGGED_IN = "logged in";
    private final CardLayout cardLayout;
    private final JPanel views;

    public ViewManager(JPanel views, CardLayout cardLayout, UserViewModel userViewModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        userViewModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            UserViewModel.LoginState newValue = (UserViewModel.LoginState) evt.getNewValue();
            switch (newValue) {
                case WELCOME -> cardLayout.show(views, WELCOME);
                case SIGNING_UP -> cardLayout.show(views, SIGN_UP);
                case LOGGING_IN -> cardLayout.show(views, LOG_IN);
                case LOGGED_IN -> cardLayout.show(views, LOGGED_IN);
                default -> throw new IllegalStateException("Unexpected value: " + evt.getNewValue());
            }
        }
    }
}
