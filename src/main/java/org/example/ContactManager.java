package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

class Contact implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
    String name;
    String phone;
    String imagePath;

    public Contact(String name, String phone, String imagePath) {
        this.name = name;
        this.phone = phone;
        this.imagePath = imagePath;
    }
}

public class ContactManager extends JFrame {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private JTextField nameField, phoneField;
    private JLabel imageLabel;
    private String imagePath;

    public ContactManager() throws HeadlessException {
        super();
        setTitle("Contact Manager");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        nameField = new JTextField(15);
        phoneField = new JTextField(15);
        imageLabel = new JLabel("No Image Selected");

        JButton addButton = new JButton("Add Contact");
        JButton loadButton = new JButton("Load Contacts");
        JButton saveButton = new JButton("Save Contacts");
        JButton chooseImageButton = new JButton("Choose Image");

        addButton.addActionListener(e -> addContact());
        loadButton.addActionListener(e -> loadContacts());
        saveButton.addActionListener(e -> saveContacts());
        chooseImageButton.addActionListener(e -> chooseImage());

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Phone:"));
        add(phoneField);
        add(chooseImageButton);
        add(imageLabel);
        add(addButton);
        add(loadButton);
        add(saveButton);
    }

    private void addContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        if (name.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and Phone cannot be empty");
            return;
        }
        contacts.add(new Contact(name, phone, imagePath));
        JOptionPane.showMessageDialog(this, "Contact added!");
        nameField.setText("");
        phoneField.setText("");
        imageLabel.setText("No Image Selected");
        imagePath = null; // Reset image path
    }

    private void loadContacts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contacts.dat"))) {
            contacts = (ArrayList<Contact>) ois.readObject();
            JOptionPane.showMessageDialog(this, "Contacts loaded! Total contacts: " + contacts.size());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "No contacts found. Please save contacts first.");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error loading contacts: " + e.getMessage());
        }
    }

    private void saveContacts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contacts.dat"))) {
            oos.writeObject(contacts);
            JOptionPane.showMessageDialog(this, "Contacts saved! Total contacts: " + contacts.size());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving contacts: " + e.getMessage());
        }
    }

    private void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            imagePath = fileChooser.getSelectedFile().getAbsolutePath();
            imageLabel.setText("Image Selected: " + imagePath);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContactManager manager = new ContactManager();
            manager.setVisible(true);
        });
    }
}