package com.mycompany.prog5121_poe;

public class Login {
    private String registeredUsername;
    private String registeredPassword;
    private String registeredCellphone;
    private String registeredFirstName;
    private String registeredLastName;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;
        boolean hasCap = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        return hasCap && hasDigit && hasSpecial;
    }
    public boolean checkCellPhoneNumber(String cell) {
        return cell.matches("^\\+27\\d{9}$");
    }
    public String registerUser(String username, String password, String cell, String firstName, String lastName) {
        if (!checkUserName(username)) return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        if (!checkPasswordComplexity(password)) return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        if (!checkCellPhoneNumber(cell)) return "Cell phone number incorrectly formatted or does not contain international code.";
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.registeredCellphone = cell;
        this.registeredFirstName = firstName;
        this.registeredLastName = lastName;
        return "User registered successfully.";
    }
    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + registeredFirstName + " " + registeredLastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}