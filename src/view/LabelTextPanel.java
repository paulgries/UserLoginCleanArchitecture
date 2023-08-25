package view;

import javax.swing.*;

// Frameworks/Drivers layer

/**
 * A panel containing a label and a text field.
 */
public class LabelTextPanel extends JPanel {
    public LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
