// ShoppingCartSimulation.java
// A simple Shopping Cart simulation using Java Swing components.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoppingCartSimulation extends JFrame implements ActionListener {

    // Declare checkboxes for the items
    JCheckBox laptop, phone, headphones;

    // Declare a button to generate the bill
    JButton generateBill;

    // Constructor to set up the GUI
    ShoppingCartSimulation() {
        // Set the title of the window
        setTitle("Shopping Cart Simulation");

        // Set layout for the frame
        setLayout(new GridLayout(5, 1, 10, 10));  // rows, cols, hgap, vgap

        // Create checkboxes with item names and prices
        laptop = new JCheckBox("Laptop - ₹60,000");
        phone = new JCheckBox("Phone - ₹25,000");
        headphones = new JCheckBox("Headphones - ₹3,000");

        // Create the Generate Bill button
        generateBill = new JButton("Generate Bill");

        // Add components to the frame
        add(new JLabel("Select the items you wish to purchase:"));
        add(laptop);
        add(phone);
        add(headphones);
        add(generateBill);

        // Register action listener for the button
        generateBill.addActionListener(this);

        // Set default close operation and size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null); // Center the window on screen
        setVisible(true);
    }

    // Handle button click events
    public void actionPerformed(ActionEvent e) {
        int total = 0;
        StringBuilder billDetails = new StringBuilder("Your Bill:\n\n");

        // Check which items are selected and add their prices
        if (laptop.isSelected()) {
            billDetails.append("Laptop: ₹60,000\n");
            total += 60000;
        }
        if (phone.isSelected()) {
            billDetails.append("Phone: ₹25,000\n");
            total += 25000;
        }
        if (headphones.isSelected()) {
            billDetails.append("Headphones: ₹3,000\n");
            total += 3000;
        }

        // If no item is selected
        if (total == 0) {
            billDetails.append("No items selected.\n");
        }

        billDetails.append("\n----------------------\n");
        billDetails.append("Total Amount: ₹" + total);

        // Display the bill in a message dialog
        JOptionPane.showMessageDialog(this, billDetails.toString(), "Bill Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Use Swing's Event Dispatch Thread (best practice for GUI apps)
        SwingUtilities.invokeLater(() -> new ShoppingCartSimulation());
    }
}


