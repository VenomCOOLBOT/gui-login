import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel headingLabel = new JLabel("Welcome to Our Registration Portal");
        JPanel headingPanel = createCenteredPanel(headingLabel);

        JPanel registrationPanel = createRegistrationPanel();

        mainPanel.add(headingPanel);
        mainPanel.add(registrationPanel);

        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createRegistrationPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.WEST;

        String[] labels = {"Enter your name:", "Enter your password:", "Enter email:"};
        JTextField[] textFields = {new JTextField(20), new JPasswordField(20), new JTextField(20)};

        for (int i = 0; i < labels.length; i++) {
            constraints.gridx = 0;
            constraints.gridy = i;
            JLabel label = new JLabel(labels[i]);
            panel.add(label, constraints);

            constraints.gridx = 1;
            panel.add(textFields[i], constraints);
        }

        constraints.gridy++;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton button = new JButton("Register");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thanks for registering. We'll get back to you shortly.");
                for (JTextField textField : textFields) {
                    textField.setText("");
                }
            }
        });

        panel.add(button, constraints);

        return panel;
    }

    private static JPanel createCenteredPanel(Component component) {
        JPanel panel = new JPanel();
        panel.add(component);
        return panel;
    }
}
