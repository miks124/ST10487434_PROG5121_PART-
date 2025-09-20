/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe_st10487434;

import java.util.Scanner;
/**
 *
 * @author mikhy
 */
public class Poe_st10487434 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        //First name and last name
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();

        //Username input with validation
        String username;
        while (true) {
            System.out.print("Create a username (must be 5 characters with '_'): ");
            username = sc.nextLine();

            if (username.length() == 5 && username.contains("_")) {
                break;
            } else {
                System.out.println("Invalid username. It must be exactly 5 characters and contain '_'. Try again.");
            }
        }

        //Password input with validation
        String password;
        while (true) {
            System.out.print("Create a password (8+ characters, include capital, number, special character): ");
            password = sc.nextLine();

            if (isValidPassword(password)) {
                break;
            } else {
                System.out.println("Invalid password. Must be 8+ characters, contain uppercase, number, and special character.");
            }
        }

        //Cellphone number validation
        String cellPhone;
        while (true) {
            System.out.print("Enter cellphone number (e.g. +27821234567): ");
            cellPhone = sc.nextLine();

            if (cellPhone.matches("\\+[0-9]{1,3}[0-9]{1,10}")) {
                break;
            } else {
                System.out.println("Invalid cellphone. Must start with +countrycode and up to 10 digits. Example: +27821234567");
            }
        }

        //Create Login object
        Login user = new Login(firstName, lastName, username, password, cellPhone);

        System.out.println("Registration successful!");

        //Login loop
        boolean success = false;
        while (!success) {
            System.out.println("--- Login ---");
            System.out.print("Enter username: ");
            String loginUsername = sc.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = sc.nextLine();

            success = user.loginUser(loginUsername, loginPassword);

            System.out.println(user.returnLoginStatus(success));
        }

        sc.close();
    }

    // Helper method
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) return false;

        boolean hasCapital = false, hasNumber = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasCapital && hasNumber && hasSpecial;
    }
}