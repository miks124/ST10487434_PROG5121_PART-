/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_st10487434;

/**
 *
 * @author mikhy
 */
public class Login {
    //declarations of variables
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhone;
    
    //constructor
    public Login(String firstName, String lastName, String username, String password, String cellPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;}
        
     //Check Username
    public boolean checkUserName(String username) {
        return username.length() == 5 && username.contains("_");
    }

    //Check Password Complexity
    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        return hasCapital && hasNumber && hasSpecial;
    }

    //Check Cell Phone
    public boolean checkCellPhoneNumber(String cellPhone) {
        return cellPhone.startsWith("+") && cellPhone.length() >= 11 && cellPhone.length() <= 15;
    }

    //Register User
    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "The username is incorrectly formatted.";
        }
        if (!checkPasswordComplexity(password)) {
            return "The password does not meet the complexity requirements.";
        }
        return "The two above conditions have been met, and the user has been registered successfully.";
    }

    //Login User
    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    //Return Login Status
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }        
    }
