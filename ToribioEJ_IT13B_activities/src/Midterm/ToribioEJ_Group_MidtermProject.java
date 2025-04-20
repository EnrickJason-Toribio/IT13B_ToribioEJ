package Midterm;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ToribioEJ_Group_MidtermProject {
    static final String username_password = "C:\\Users\\Jayboy\\Desktop\\java programs\\Account_encrypted.txt";
    static final int SHIFT = 3;
    static Scanner scanner = new Scanner(System.in);

    static String[] menu = {"Classic Buffalo Wings", "Barbecue Chicken Wings", "Honey Mustard Wings"};
    static int[] prices = {189, 199, 209};

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n Welcome to PakPak All U Can ");
            System.out.println("1. Create an account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: register(); 
                break;
                
                case 2: login(); 
                break;
                
                case 3: System.out.println("Thank you. Goodbye!"); 
                break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    static void register() {
        try {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            String encryptedPassword = caesarEncrypt(password);

            FileWriter writer = new FileWriter(username_password, true);
            writer.write(username + "," + encryptedPassword + "\n");
            writer.close();

            System.out.println("Account created successfully!");
        } catch (IOException e) {
            System.out.println("Error during registration.");
        }
    }

    static void login() {
        try {
            System.out.print("Enter Username: ");
            String inputUser = scanner.nextLine();
            System.out.print("Enter Password: ");
            String inputPass = scanner.nextLine();

            File file = new File(username_password);
            if (!file.exists()) {
                System.out.println("No users registered yet.");
                return;
            }

            FileReader user_pass = new FileReader(file);
            StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = user_pass.read()) != -1) {
                content.append((char) ch);
            }
            user_pass.close();

            String[] lines = content.toString().split("\n");
            boolean found = false;
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length != 2) continue;
                String storedUsername = parts[0];
                String storedEncryptedPassword = parts[1];
                String decryptedPassword = caesarDecrypt(storedEncryptedPassword);

                if (storedUsername.equals(inputUser) && decryptedPassword.equals(inputPass)) {
                    System.out.println("Login successful!");
                    orderMenu();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Invalid credentials.");
            }
        } catch (IOException e) {
            System.out.println("Error during login.");
        }
    }

    static void orderMenu() {
        int[] quantities = new int[menu.length];
        int choice;

        do {
            System.out.println("\n PakPak All U Can Menu ");
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("%d. %s - P%d\n", i + 1, menu[i], prices[i]);
            }
            System.out.println("4. Exit and Show Bill");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 3) {
                System.out.print("Enter quantity for " + menu[choice - 1] + ": ");
                int qty = scanner.nextInt();
                quantities[choice - 1] += qty;
                System.out.println("Added to order.");
            } else if (choice != 4) {
                System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        // Show summary
        int total = 0;
        System.out.println("\n Order Summary ");
        for (int i = 0; i < menu.length; i++) {
            if (quantities[i] > 0) {
                int itemTotal = quantities[i] * prices[i];
                total += itemTotal;
                System.out.printf("%s x%d = P%d\n", menu[i], quantities[i], itemTotal);
            }
        }
        System.out.println("Total Bill: P" + total);
    }

    static String caesarEncrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append((char) (c + SHIFT));
        }
        return result.toString();
    }

    static String caesarDecrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append((char) (c - SHIFT));
        }
        return result.toString();
    }
}
