package view;

import interface_adapters.UserViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends JPanel implements ActionListener {
    /**
     * The username chosen by the user
     */
    final JTextField username = new JTextField(15);
    /**
     * The password
     */
    final JPasswordField password = new JPasswordField(15);

    final JButton logIn = new JButton("Log in");
    final JButton cancel = new JButton("Cancel");

    /**
     * A window with a title and a JButton.
     */
    public LoginView(UserViewModel userViewModel) {

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(cancel);

        logIn.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

}