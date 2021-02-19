package MemeDatabase;

import java.util.Scanner;

public class MemeDatabase {

    public static void main (String[] args) {
        String username;
        String password;
        System.out.println("Welcome to Meme Database!");
        if (getInput("Do you have an account? [y/n] ") != null) { // if the user has an account
            username = getInput("Username");
            password = getInput("Password");
        } else { // if the user does not have an account and needs to register an account
            username = getInput("Enter a username you want");
            password = getInput("Enter the password you want");
        }
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
