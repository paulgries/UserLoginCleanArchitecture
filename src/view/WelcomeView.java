package view;

import interface_adapters.UserViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeView extends JPanel implements ActionListener {

    private final UserViewModel userViewModel;
    private final JButton logIn = new JButton("Log in");
    private final JButton signUp = new JButton("Sign up");

    /**
     * A window with a title and a JButton.
     */
    public WelcomeView(UserViewModel userViewModel) {
        this.userViewModel = userViewModel;

        JLabel title = new JLabel("Welcome Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(signUp);

        logIn.addActionListener(this);
        signUp.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(logIn)) {
            userViewModel.setState(UserViewModel.LoginState.LOGGING_IN);
        } else if (evt.getSource().equals(signUp)) {
            userViewModel.setState(UserViewModel.LoginState.SIGNING_UP);
        }
    }

}