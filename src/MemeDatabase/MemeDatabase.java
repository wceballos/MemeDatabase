package MemeDatabase;

import java.util.Scanner;

public class MemeDatabase {

    private Account account;

    public static void main (String[] args) {
        String username;
        String password;
        String email;
        System.out.println("Welcome to Meme Database!");
        if (getInput("Do you have an account? [y/n] ") != null) { // if the user has an account
            username = getInput("Username");
            password = getInput("Password");
            boolean isLoggedIn = false;
            while (!isLoggedIn) {
                isLoggedIn = logIn(username, password);
            }
        } else { // if the user does not have an account and needs to register an account
            username = getInput("Enter a username you want");
            password = getInput("Enter the password you want");
            email = getInput("Enter your email");
            boolean isCreated = false;
            while (!isCreated) {
                isCreated = createNewAccount(username, password, email);
            }
        }
    }

    public static logIn (String username, String password) { // verify that the log in is correct using a query against the databse
        // TODO
        // CHECK THAT USER EXISTS
        return true; // test stub
    }

    public static createNewAccount (String username, String password, String email) { // make a query to DB to insert a new account
        // TODO
        // NEED TO DO SOME CHECKING TO MAKE SURE THAT USERNAME OR EMAIL DOES NOT EXIT
        return false // test stub
    }

    public static getInput (String question) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        String confirm = "";
        while (!confirm.equals("y") || !confirm.equals("yes")) {
            System.out.print(question + ": ");
            input = scan.nextLine();
            System.out.print("Is " + input + " correct? [y/n] ");
            confirm = scan.nextLine();
        }
        return input;
    }

}
