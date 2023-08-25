package view;

import interface_adapters.UserViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer

public class SignupView extends JPanel implements ActionListener {
    private final UserViewModel userViewModel;
    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);
    /**
     * The second password to make sure the user understands
     */
    JPasswordField repeatPassword = new JPasswordField(15);

    /**
     * The controller
     */
    UserSignupController userSignupController;

    JButton signUp = new JButton("Sign up");
    JButton cancel = new JButton("Cancel");


    /**
     * A window with a title and a JButton.
     */
    public SignupView(UserSignupController controller, UserViewModel userViewModel) {

        this.userSignupController = controller;
        this.userViewModel = userViewModel;

        JLabel title = new JLabel("Register Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Choose username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Choose password"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel("Enter password again"), repeatPassword);


        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(cancel);

        signUp.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        if (evt.getSource().equals(signUp)) {
            try {
                userSignupController.create(username.getText(),
                        String.valueOf(password.getPassword()),
                        String.valueOf(repeatPassword.getPassword()));
                userViewModel.setCurrentUser(username.getText());
                JOptionPane.showMessageDialog(this, "%s created.".formatted(username.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        } else if (evt.getSource().equals(cancel)) {
        }

        // No matter what, return to the welcome screen.
        userViewModel.setState(UserViewModel.LoginState.WELCOME);
    }

}