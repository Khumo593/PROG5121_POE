package com.mycompany.prog5121_poe;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        
        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        String lastName = JOptionPane.showInputDialog("Enter Last Name:");
        String username = JOptionPane.showInputDialog("Enter Username (must contain _ and <=5 chars):");
        String password = JOptionPane.showInputDialog("Enter Password (8 chars, Cap, number, special):");
        String cell = JOptionPane.showInputDialog("Enter Cell (+27 number, e.g. +27838968976):");

        String regResult = login.registerUser(username, password, cell, firstName, lastName);
        JOptionPane.showMessageDialog(null, regResult);

        if (regResult.equals("User registered successfully.")) {
            String loginUser = JOptionPane.showInputDialog("LOGIN - Enter Username:");
            String loginPass = JOptionPane.showInputDialog("LOGIN - Enter Password:");
            String status = login.returnLoginStatus(loginUser, loginPass);
            JOptionPane.showMessageDialog(null, status);
        }
    }
}