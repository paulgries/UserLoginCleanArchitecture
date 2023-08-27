package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoggedInView extends JPanel implements ActionListener {
    /**
     * The username chosen by the user
     */
     private final JTextField username = new JTextField(15); // maybe a JLabel?
    /**
     * A window with a title and a JButton.
     */
    public LoggedInView() {

        JLabel title = new JLabel("Logged-in Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logOut = new JButton("Log out");
        JButton changePassword = new JButton("Change password");

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        username.setEditable(false);

        JPanel buttons = new JPanel();
        buttons.add(logOut);
        buttons.add(changePassword);

        logOut.addActionListener(this);
        changePassword.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}