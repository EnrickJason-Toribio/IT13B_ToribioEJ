package Midterm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.Scanner;

public class ToribioEJ_JFrame {

    public ToribioEJ_JFrame() {
        JFrame Jframe = new JFrame("Login");

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JLabel Username = new JLabel("Username:");
        JLabel Password = new JLabel("Password:");
        JButton Login = new JButton("Login");

        Jframe.setLayout(new GridLayout(3, 2));
        Jframe.getContentPane().add(Username);
        Jframe.getContentPane().add(username);
        Jframe.getContentPane().add(Password);
        Jframe.getContentPane().add(password);
        Jframe.getContentPane().add(Login);
        
        
        Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = username.getText();
                String enteredPassword = new String(password.getPassword());
        
      boolean correct = authenticateUser(enteredUsername, enteredPassword);

                if (correct) {
                    JOptionPane.showMessageDialog(Jframe, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(Jframe, "Invalid username or password.");
                }
            }
        });
        
        
        Jframe.setBounds(600, 300, 300, 150);
        Jframe.setVisible(true);
        Jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private boolean authenticateUser(String enteredUsername, String enteredPassword) {
        try (BufferedReader myReader = new BufferedReader(new FileReader("C:\\Users\\Jayboy\\Desktop\\java programs\\JFrame.txt"))) {
            String line;
            while ((line = myReader.readLine()) != null) {
                String[] Account = line.split(",");
                String storedUsername = Account[0];
                String storedPassword = Account[1];

               
                if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
                    return true; 
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return false; 
    }
    public static void main(String[] args){
        new ToribioEJ_JFrame();
    }
        }
    
