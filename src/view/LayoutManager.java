package view;

import interface_adapters.UserViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LayoutManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;

    public LayoutManager(JPanel views, CardLayout cardLayout, UserViewModel userViewModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        userViewModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            UserViewModel.LoginState newValue = (UserViewModel.LoginState) evt.getNewValue();
            switch (newValue) {
                case WELCOME -> cardLayout.show(views, "welcome");
                case SIGNING_UP -> cardLayout.show(views, "signup");
                case LOGGING_IN -> cardLayout.show(views, "login");
                case LOGGED_IN -> cardLayout.show(views, "loggedIn");
                default -> throw new IllegalStateException("Unexpected value: " + evt.getNewValue());
            }
        }
    }
}
