
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class new1 {
    // Default conversion rate (Rupees to Dollars)
    private static final double CONVERSION_RATE = 65.25;

    // Method to initialize and display the converter GUI
    public static void converter() {
        JFrame f = new JFrame("Currency Converter");

        // Creating labels
        JLabel l1, l2;
        l1 = new JLabel("Rupees:");
        l2 = new JLabel("Dollars:");

        // Creating text fields for input
        JTextField t1 = new JTextField("0", 10);
        JTextField t2 = new JTextField("0", 10);
        t1.setEditable(true);
        t2.setEditable(false);

        // Creating buttons
        JButton b1 = new JButton("Convert to Dollars");
        JButton b2 = new JButton("Convert to Rupees");
        JButton b3 = new JButton("Reset");
        JButton b4 = new JButton("Close");

        // Setting button and label font styles for better appearance
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        b1.setFont(buttonFont);
        b2.setFont(buttonFont);
        b3.setFont(buttonFont);
        b4.setFont(buttonFont);
        l1.setFont(new Font("Arial", Font.PLAIN, 14));
        l2.setFont(new Font("Arial", Font.PLAIN, 14));

        // Setting the layout manager for better layout
        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adding labels and text fields with GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        f.add(l1, gbc);
        
        gbc.gridx = 1;
        f.add(t1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        f.add(l2, gbc);

        gbc.gridx = 1;
        f.add(t2, gbc);

        // Adding buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(b1, gbc);

        gbc.gridy = 3;
        f.add(b2, gbc);

        gbc.gridy = 4;
        f.add(b3, gbc);

        gbc.gridy = 5;
        gbc.gridwidth = 1;
        f.add(b4, gbc);

        // Button functionality
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double rupees = Double.parseDouble(t1.getText());
                    double dollars = rupees / CONVERSION_RATE;
                    t2.setText(String.format("%.2f", dollars));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Please enter a valid number for Rupees.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double dollars = Double.parseDouble(t2.getText());
                    double rupees = dollars * CONVERSION_RATE;
                    t1.setText(String.format("%.2f", rupees));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Please enter a valid number for Dollars.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Resetting both fields to 0
                t1.setText("0");
                t2.setText("0");
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();  // Close the window
            }
        });

        // Setting up the window
        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);  // Center the frame
        f.setVisible(true);
    }

    // Driver code to launch the converter
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new1::converter);
    }
}
